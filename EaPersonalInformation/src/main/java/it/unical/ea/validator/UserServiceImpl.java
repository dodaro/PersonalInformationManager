package it.unical.ea.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

import it.unical.ea.model.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {
    
	@Autowired
	private ApplicationContext context;
	
    UserDao userDao;

    @Override
    public boolean fieldValueExists(Object value, String fieldName) throws UnsupportedOperationException {
        Assert.notNull(fieldName);
        userDao = (UserDao) context.getBean("userDao");

        if (!fieldName.equals("email")) {
            throw new UnsupportedOperationException("Field name not supported");
        }

        if (value == null) {
            return false;
        }
		
        return this.userDao.exists(value.toString());
    }
    
}
