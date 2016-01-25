package it.unical.ea.model.dao;

import java.util.List;
import it.unical.ea.model.Account;
import it.unical.ea.model.User;

public interface AccountDao {
	
	void create(Account account);

	Account getAccount(Integer id);

	Account getAccount(String accountname);
	
	boolean exists(String accountname);

	void update(Account account);

	void delete(Account account);

	int numberOfAccounts();

	List<Account> getAccounts();
	
	void deleteFromId(Integer id);
	
	List<Account> getUserAccounts(User user);
}
