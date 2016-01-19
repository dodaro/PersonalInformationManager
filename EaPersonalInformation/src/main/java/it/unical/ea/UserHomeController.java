package it.unical.ea;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import it.unical.ea.model.Account;
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
	private WebApplicationContext context;
	
	private static final Logger logger = LoggerFactory.getLogger(UserHomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	private HashMap<String, String> initPassworList(){
		PwdGen pwds = new PwdGen();
		HashMap<String, String> pwdChooser = new HashMap<String, String>();
		
		pwdChooser.put(pwds.onlyletters(), "Letters Only");
		pwdChooser.put(pwds.onlylettersandnumbers(), "Letters and Digits");
		pwdChooser.put(pwds.letNumSpecialChar(), "Letters Digits Special ");
		
		return  pwdChooser;
	}
	
	@RequestMapping(value = "/userhome", method = RequestMethod.GET)
	public String userhome(Locale locale, Model model, HttpServletRequest request, HttpSession session) {
		logger.info("Welcome HomeUser", locale);
		UserDao userDao = (UserDao) context.getBean("userDao");
		String userEmail = (String) session.getAttribute("user");
		if (userEmail == null)
			return "redirect:/";
		
		logger.info("User email " + userEmail);
		User user = userDao.retrieveEmail(userEmail);
		String userName = user.getFirstname() + " " + user.getLastname();
		model.addAttribute("username", userName);
		model.addAttribute("accountForm", new Account());
		model.addAttribute("pwdList", initPassworList());
		return "userhome";
	}
	

	@RequestMapping(value = "/userhome", method = RequestMethod.POST)
	public String userhomePost(@Valid @ModelAttribute("accountForm") Account accountNew, BindingResult result, 
			Model model, HttpServletRequest request, HttpSession session) {
		logger.info("Welcome HomeUser Post");
		UserDao userDao = (UserDao) context.getBean("userDao");
		String userEmail = (String) session.getAttribute("user");
		if (userEmail == null)
			return "redirect:/";
		List<Account> myAccounts;
		
		logger.info("User email " + userEmail);
		User user = userDao.retrieveEmail(userEmail);
		String userName = user.getFirstname() + " " + user.getLastname();
		model.addAttribute("username", userName);
		
		if(result.hasErrors()) {
			logger.info("Account Error");
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Account adding error. Check and retry.");
			return "userhome";
		}

		@SuppressWarnings("rawtypes")
		Enumeration prova = request.getAttributeNames();
		System.out.println("request Start");
		while(prova.hasMoreElements()) {
			System.out.println("request " + prova.nextElement());
		}
		
		
		@SuppressWarnings("rawtypes")
		Enumeration provasession = session.getAttributeNames();
		System.out.println("session Start");
		while(provasession.hasMoreElements()) {
			System.out.println("session " + provasession.nextElement());
		}
		
		logger.info("Account Post");
		System.out.println("1 " + accountNew.getAccountname());
		System.out.println("2 " + accountNew.getType());
		System.out.println("3 " + accountNew.getUsername());
		System.out.println("4 " + accountNew.getPassword());
		System.out.println("5 " + accountNew.getNotes());
		
		
		accountNew.setUser(user);
		AccountDao accountDao = (AccountDao) context.getBean("accountDao");
		
		
		if (accountDao.exists(accountNew.getAccountname())) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Account Name already exists. Please change account name.");
			return "userhome";
		} else {
			accountDao.create(accountNew);
			model.addAttribute("css", "success");
			model.addAttribute("msg", "Account added correctly.");
			model.addAttribute("accountForm", new Account());
			
			myAccounts = userDao.getAccounts(user);
			logger.info("Account Query");
			for (Account temp : myAccounts) {
				System.out.println(temp);
			}
			return "userhome";
		}
		
		

	}
	
//	@RequestMapping(value = "/userhome/getTags", method = RequestMethod.POST) 
//	@ResponseBody  public  String getTags(@RequestParam("tagName") String tagName) {
//	        logger.info("Procedura strana");
//			PwdGen pwdGen = (PwdGen) context.getBean("pwdGen");
//	       
//	        String genPass = pwdGen.onlyletters();
//	        
//	        return genPass;  
//	 }
	
	@RequestMapping(value = "/userhome/getTags", method = RequestMethod.POST)
	@ResponseBody public String getTags(@RequestParam("tagName") String tagName) {
	
		System.out.println("Value from Ajax request" + tagName);
	
		if(tagName!=null){
			System.out.println("tagName is not null" + tagName);
		}
		PwdGen pwdGen = (PwdGen) context.getBean("pwdGen");
	    String genPass = pwdGen.onlyletters();
	    
	    return genPass; 
	}
	
	
}
