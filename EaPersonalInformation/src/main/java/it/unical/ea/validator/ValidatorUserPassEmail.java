package it.unical.ea.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.context.WebApplicationContext;

import it.unical.ea.model.User;
import it.unical.ea.model.dao.UserDao;

public class ValidatorUserPassEmail implements Validator {
	
//	@Autowired
//	private ApplicationContext context;
//	
//    UserDao userDao;


	public ValidatorUserPassEmail() {
/*		userDao = (UserDao) context.getBean("userDao");
		System.out.println(userDao.numberOfUsers());*/
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		User user = (User) target;
		if (!user.getPassword().equals(user.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "mismatchPass", "Password does not match.");
		}
		if (!user.getEmail().equals(user.getConfirmEmail())) {
			errors.rejectValue("confirmEmail", "mismatchEmail", "Email does not match.");
		}
		
/*		if (userDao.exists(user.getEmail())) {
			errors.rejectValue("email", "aleadyEmail", "Email is already in the database.");
		}*/
		
	}

}
