package it.unical.ea.model.dao;

import java.util.List;
import it.unical.ea.model.Account;

public interface AccountDAO {
	public void create(Account account);

	public Account get(Integer id);

	public Account get(String productname);

	public void update(Account account);

	public void delete(Account account);

	public int numberOfAccounts();

	public List<Account> getAccounts();
}
