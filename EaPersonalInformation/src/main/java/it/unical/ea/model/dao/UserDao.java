package it.unical.ea.model.dao;

import java.util.List;

import it.unical.ea.model.Account;
import it.unical.ea.model.User;

public interface UserDao {
	
	void create(User u);
	
	User retrieveEmail(String username);
	
	boolean exists(String username);
	
	List<Account> getAccounts(User user);
	
	Long numberOfUsers();
	
	void update(User u);
	
	void delete(User u);	
}
