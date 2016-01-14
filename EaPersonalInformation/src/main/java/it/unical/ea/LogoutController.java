package it.unical.ea;

import java.text.DateFormat;
import java.util.Date;
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
import org.springframework.web.context.WebApplicationContext;

import it.unical.ea.SessionHandler;
import it.unical.ea.model.LoginBean;
import it.unical.ea.model.PwdGen;
import it.unical.ea.model.User;
import it.unical.ea.model.dao.UserDao;
import it.unical.ea.validator.ValidatorUserPassEmail;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LogoutController {
	
	@Autowired
	private WebApplicationContext context;
	
	private static final Logger logger = LoggerFactory.getLogger(LogoutController.class);
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Locale locale, Model model, HttpServletRequest request, HttpSession session) {
		logger.info("Welcome Logout");
		model.addAttribute("userLogin", new LoginBean());
		if(session != null) {
			session.removeAttribute("user");
			}
		session.invalidate();
		return "logout";
	}
	
	
}
