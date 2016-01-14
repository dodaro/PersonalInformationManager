package it.unical.ea;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.context.WebApplicationContext;

import it.unical.ea.SessionHandler;
import it.unical.ea.model.LoginBean;
import it.unical.ea.model.PassHasher;
import it.unical.ea.model.PwdGen;
import it.unical.ea.model.User;
import it.unical.ea.model.dao.UserDao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
	
	@Autowired
	private WebApplicationContext context;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) {
		logger.info("Welcome Login Page", locale);
//		if (!SessionHandler.existsUser(request.getSession()))
//			return "redirect:/";
		model.addAttribute("userLogin", new LoginBean());
		
		return "login";
	}
	
	//Order of BindingResult matters (it must be just after ModelAttribute)
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String registrationPost(@Valid @ModelAttribute("userLogin") LoginBean userLogin, BindingResult result, 
			Model model, HttpServletRequest request) {
		
		UserDao userDao = (UserDao) context.getBean("userDao");
		
		String encrypted = PassHasher.encryptSHA512(userLogin.getPassword());
		
		if (!userDao.exists(userLogin.getEmail()) || !(userDao.retrieveEmail(userLogin.getEmail()).getPassword().equals(encrypted))) {			
			model.addAttribute("userexerror", "true");			
			return "login";
		}
		request.getSession().setAttribute("user", userLogin.getEmail());		
		
		
		return "redirect:/userhome";
		
		
//		if (userLogin.getEmail().equals(user.getEmail()) && userLogin.getPassword().equals(user.getPassword())) {
//			request.getSession().setAttribute("userSession", userLogin.getEmail());
//			return "redirect:/userhome";
//		} else {
//			model.addAttribute("userexerror", "true");
//			model.addAttribute("userLogin", new LoginBean());
//			return "login";
//		}
		
	
	}
}
