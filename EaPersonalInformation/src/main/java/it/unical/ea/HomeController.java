package it.unical.ea;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import it.unical.ea.SessionHandler;
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
	public String home(Locale locale, Model model, HttpServletRequest request) {
		logger.info("Welcome Password generator", locale);
//		if (!SessionHandler.existsUser(request.getSession()))
//			return "redirect:/";
		
		PwdGen mypass = context.getBean("passGen", PwdGen.class);
		
		logger.info("Generated password: " + mypass.onlyletters());
		logger.info("Generated password: " + mypass.onlylettersandnumbers());
		logger.info("Generated password: " + mypass.LetNumSpecialChar());
		return "home";
	}
	
}
