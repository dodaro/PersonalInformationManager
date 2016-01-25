package it.unical.ea;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import it.unical.ea.model.LoginBean;
import it.unical.ea.model.PwdGen;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private WebApplicationContext context;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request) {
		logger.info("Welcome Password generator & Login");

		model.addAttribute("userLogin", new LoginBean());
		
		PwdGen mypass = context.getBean("pwdGen", PwdGen.class);
		
		logger.info("Generated password: " + mypass.getPwdLett());
		logger.info("Generated password: " + mypass.getPwdLettNum());
		logger.info("Generated password: " + mypass.getPwdLettNumSpec());
		return "home";
	}
	
	
}
