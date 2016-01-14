package it.unical.ea;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import it.unical.ea.model.PassHasher;
import it.unical.ea.model.User;
import it.unical.ea.model.dao.UserDao;
import it.unical.ea.validator.ValidatorUserPassEmail;

/**
 * Handles requests for the application home page.
 */
@Controller
public class RegistrationController {
	
	@Autowired
	private WebApplicationContext context;
	
	private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registrationGet(Locale locale, Model model, HttpServletRequest request) {
		logger.info("Welcome Registration", locale);
//		if (!SessionHandler.existsUser(request.getSession()))
//			return "redirect:/";
		model.addAttribute("userForm", new User());
		return "registration";
	}
	
	//Order of BindingResult matters (it must be just after ModelAttribute)
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registrationPost(@Valid @ModelAttribute("userForm") User userReg, BindingResult result, 
			Model model, HttpServletRequest request) {
		
		ValidatorUserPassEmail userValidator = new ValidatorUserPassEmail();
		userValidator.validate(userReg, result);
		if(result.hasErrors()) {
			logger.info("Registration Error");
			return "registration";
		}
//		User userRetrived = userReg.retrieve
		
		logger.info("Registration Post");
		System.out.println("1 " + userReg.getEmail());
		System.out.println("2 " + userReg.getFirstname());
		System.out.println("3 " + userReg.getLastname());
		System.out.println("4 " + userReg.getPassword());
		System.out.println("5 " + userReg.getDateOfBirth());
		
		String encrypted = PassHasher.encryptSHA512(userReg.getPassword());
		userReg.setPassword(encrypted);
		
		logger.info("Password Encrypted " + encrypted);
		
		UserDao userDao = (UserDao) context.getBean("userDao");
		if (userDao.exists(userReg.getEmail())) {
			model.addAttribute("userexerror", "true");
			return "registration";
		} else {
			userDao.create(userReg);
			return "redirect:/";
		}

	}
}
