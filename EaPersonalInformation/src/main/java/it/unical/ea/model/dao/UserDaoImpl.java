package it.unical.ea.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import it.unical.ea.model.Account;
import it.unical.ea.model.DBHandler;
import it.unical.ea.model.User;

public class UserDaoImpl implements UserDao {

	private DBHandler dbHandler;
	
	public DBHandler getDbHandler() {
		return dbHandler;
	}

	public void setDbHandler(DBHandler dbHandler) {
		this.dbHandler = dbHandler;
	}

	public UserDaoImpl() {
	}
	
	@Override
	public void create(User user) {
		dbHandler.create(user);
	}

	@Override
	public void delete(User user) {
		dbHandler.delete(user);
	}
		
	@Override
	public void update(User user) {
		dbHandler.update(user);
	}

	@Override
	public User retrieveEmail(String email) {	
		Session session = dbHandler.getSessionFactory().openSession();
		String queryString = "from User where email = :email";
		Query query = session.createQuery(queryString);
		query.setParameter("email", email);
		User u = (User) query.uniqueResult();	
		session.close();	
	    return u;
	}
	
	@Override
	public boolean exists(String email) {
		return retrieveEmail(email) != null;
	}
	
	@Override
	public List<Account> getAccounts(User user) {
		Session session = dbHandler.getSessionFactory().openSession();
		String queryString = "from User u where u.id = :userid";
		Query query = session.createQuery(queryString);
		query.setParameter("userid", user.getId());
		User userlocal = (User)query.uniqueResult();
		List<Account> accounts = (List<Account>) userlocal.getAccounts();
		session.close();
		return accounts;
	}

	@Override
	public Long numberOfUsers() {
		Session session = dbHandler.getSessionFactory().openSession();
		Long size = (Long) session.createQuery("select count(*) from User").uniqueResult();
		return size;
	}
}
