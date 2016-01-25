package it.unical.ea;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import it.unical.ea.model.Account;
import it.unical.ea.model.AccountCreator;
import it.unical.ea.model.PwdGen;
import it.unical.ea.model.User;
import it.unical.ea.model.dao.AccountDao;
import it.unical.ea.model.dao.UserDao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserHomeController {
	
	@Autowired
    AccountDao accountDao;
	
	@Autowired
    UserDao userDao;
	
	@Autowired
	private WebApplicationContext context;
	
	private static final Logger logger = LoggerFactory.getLogger(UserHomeController.class);
	
	
	@RequestMapping(value = "/userhome", method = RequestMethod.GET)
	public String userhome(Model model, @ModelAttribute("accountEditId") String accountEditId,
			@ModelAttribute("edit") String edit, @ModelAttribute("css") String css, @ModelAttribute("msg") String msg, 
				HttpSession session) {
		logger.info("Welcome HomeUser");
		logger.info("Css String from redirect " + css);
		logger.info("Msg String from redirect " + msg);
		
		userDao = (UserDao) context.getBean("userDao");
		String userEmail = (String) session.getAttribute("user");
		if (userEmail == null)
			return "redirect:/";
		
		
		logger.info("User email " + userEmail);
		User user = userDao.retrieveEmail(userEmail);
		String userName = user.getFirstname() + " " + user.getLastname();
		model.addAttribute("username", userName);
		model.addAttribute("user", user);
		List<Account> accountList = user.getAccounts();
//		if (!accountEditId.isEmpty()) {
//			for(Account a : accountList){
//		        if(a.getId() != null && a.getId().equals(Integer.valueOf(accountEditId))){
//		        	logger.info("Account inside For: " + a.toString());
//		        }
//		    }
//		}
		
		AccountCreator accountForm = new AccountCreator();
		Account editAccount;
		
		if (!edit.isEmpty() && edit.equals("edit") ) {
			accountDao = (AccountDao) context.getBean("accountDao");
			editAccount = accountDao.getAccount(Integer.valueOf(accountEditId));
			logger.info("Account userhome int accountEditId " + accountEditId);
			logger.info("Account userhome Update");
			accountForm.setAccount(editAccount);
			model.addAttribute("accountForm", accountForm);
			model.addAttribute("edit", "edit");
			model.addAttribute("modalTitle", "Update Account");
		}
		
		if (!edit.isEmpty() && edit.equals("new")) {
			model.addAttribute("accountForm", accountForm);
			model.addAttribute("modalTitle", "Add New Account");
			model.addAttribute("edit", "new");
		}
		
		if (edit.isEmpty()) {
			model.addAttribute("accountForm", accountForm);
			model.addAttribute("modalTitle", "Add New Account");
			model.addAttribute("edit", "");
		}
		
		model.addAttribute("accounts", accountList);
		return "userhome";
	}
	

	@RequestMapping(value = "/userhome",method = RequestMethod.POST)
	public String userhomePost(@Valid @ModelAttribute("accountForm") AccountCreator accountCreatorForm, BindingResult result, 
			Model model, @ModelAttribute("edit") String edit, HttpServletRequest request, HttpSession session) {
		logger.info("Welcome HomeUser Post");
		String userSessionEmail = (String) session.getAttribute("user");
		if (userSessionEmail == null)
			return "redirect:/";
		
		logger.info("User email " + userSessionEmail);
		
		accountDao = (AccountDao) context.getBean("accountDao");
		userDao = (UserDao) context.getBean("userDao");
		User user = userDao.retrieveEmail(userSessionEmail);
		Account account = accountCreatorForm.getAccount();
		Account accountFromDb = accountDao.getAccount(account.getAccountname());
		
		logger.info("Account Post");
		
		if (result.hasErrors() && edit.equals("new")) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Account adding error. Check and retry.");
			model.addAttribute("edit", "");
			return "redirect:/userhome";
		}
		
		if (result.hasErrors() && edit.equals("edit")) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Account updating error. Check and retry.");
			model.addAttribute("edit", "");
			return "redirect:/userhome";
		}
		

		if (edit.equals("new")) {
			if (accountFromDb != null) {
				model.addAttribute("css", "danger");
				model.addAttribute("msg", "Account Name already exists. Please change account name.");
				model.addAttribute("edit", "");
			}
			else {
				account.setUser(user);
				accountDao.create(account);
				model.addAttribute("css", "success");
				model.addAttribute("msg", "Account added correctly.");
				model.addAttribute("edit", "");
			}
			return "redirect:/userhome";
		}
		
		if (edit.equals("edit")) {
			accountFromDb.setUsername(account.getUsername());
			accountFromDb.setType(account.getType());
			accountFromDb.setPassword(account.getPassword());
			accountFromDb.setNotes(account.getNotes());
			accountDao.update(accountFromDb);
			model.addAttribute("css", "success");
			model.addAttribute("msg", "Account updated correctly.");
			model.addAttribute("edit", "");
			return "redirect:/userhome";
		}
			
		
		return "redirect:/userhome";
	}
	
	@RequestMapping(value = "/userhome", params="action1" ,method = RequestMethod.POST)
	public void  userhomePostPart1(Model model, HttpServletRequest request, HttpSession session) {
			
		AccountCreator accountCreatorForm = new AccountCreator();
			
		System.out.println("Action1 block called");
		model.addAttribute("accountForm", accountCreatorForm);
		model.addAttribute("edit", "new");
		
	}
	
	@RequestMapping(value = "/userhome", params="action2" ,method = RequestMethod.POST)
	public void  userhomePostPart2(@Valid @ModelAttribute("accountForm") AccountCreator accountCreatorForm, BindingResult result, 
			Model model, HttpServletRequest request, HttpSession session) {
			Account accountAskPwd = accountCreatorForm.getAccount();
			PwdGen pwdGen = (PwdGen)context.getBean("pwdGen");
			String password;
			System.out.println("Action2 block called");
			
			switch (accountCreatorForm.getPassType()) {
				case 0:  password = "";
						 break;
	            case 1:  password = pwdGen.getPwdLett();
	                     break;
	            case 2:  password = pwdGen.getPwdLettNum();
	                     break;
	            case 3:  password = pwdGen.getPwdLettNumSpec();
	                     break;
	            case 4:  pwdGen.setWord1(accountCreatorForm.getWord1());
	                     pwdGen.setWord2(accountCreatorForm.getWord2());
	                     password = pwdGen.getPwdTwoWords();
	                     break;
	            default: password = "Error!!!";
                		 break;
	        }
	                     
			AccountCreator accountCreatorFormNew = new AccountCreator();	
			accountAskPwd.setPassword(password);
			accountCreatorFormNew.setAccount(accountAskPwd);
			
			model.addAttribute("accountForm", accountCreatorFormNew);
			model.addAttribute("editPwd", true);
			model.addAttribute("genPassword", password);
		
	}
	
	
    @RequestMapping(value = { "/userhome/delete-account-{id}" }, method = RequestMethod.GET)
    public String deleteUser(Model model, @PathVariable Integer id) {
    	accountDao = (AccountDao) context.getBean("accountDao");
        accountDao.deleteFromId(id);
        
        model.addAttribute("css", "success");
		model.addAttribute("msg", "Account deleted correctly.");
        return "redirect:/userhome";
    }
    
    @RequestMapping(value = { "/userhome/edit-account-{id}" }, method = RequestMethod.GET)
    public String editAccountGet(@PathVariable Integer id, Model model, HttpSession session) {
    	
    	userDao = (UserDao) context.getBean("userDao");
		String userEmail = (String) session.getAttribute("user");
		if (userEmail == null)
			return "redirect:/";
    	
        model.addAttribute("accountEditId", id);
        model.addAttribute("edit", true);

        return "redirect:/userhome";
    }
 
}
