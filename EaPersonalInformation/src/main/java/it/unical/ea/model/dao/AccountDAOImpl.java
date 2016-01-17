package it.unical.ea.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import it.unical.ea.model.Account;
import it.unical.ea.model.DBHandler;

public class AccountDAOImpl implements AccountDAO {
	
	private DBHandler dbHandler;
	
	public DBHandler getDbHandler() {
		return dbHandler;
	}

	public void setDbHandler(DBHandler dbHandler) {
		this.dbHandler = dbHandler;
	}
	
	public AccountDAOImpl() {
	}

	@Override
	public void create(Account account) {
		dbHandler.create(account);
	}

	@Override
	public void update(Account account) {
		dbHandler.update(account);
	}

	@Override
	public void delete(Account account) {
		dbHandler.delete(account);
	}

	@Override
	public int numberOfAccounts() {
		Session session = dbHandler.getSessionFactory().openSession();
		int size = session.createSQLQuery("SELECT * FROM accounts").list().size();
		session.close();
		return size;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Account> getAccounts() {
		Session session = dbHandler.getSessionFactory().openSession();
		List<Account> accounts = (List<Account>) session.createQuery("from Account").list();
		session.close();
		return accounts;
	}
	
	
	@Override
	public Account get(Integer id) {
		Session session = dbHandler.getSessionFactory().openSession();
		String queryString = "from Account a where a.id = :id_account";
		Query query = session.createQuery(queryString);
		query.setParameter("id_account", id);
		Account a = (Account) query.uniqueResult();
		session.close();
		return a;
	}
	
	@Override
	public Account get(String username) {	
		Session session = dbHandler.getSessionFactory().openSession();
		String queryString = "from Account where username = :username";
		Query query = session.createQuery(queryString);
		query.setParameter("username", username);
		Account a = (Account) query.uniqueResult();	
		session.close();	
	    return a;
	}
	
}
