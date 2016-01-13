package it.unical.ea.model.dao;

import org.hibernate.Query;
import org.hibernate.Session;

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
	public Long numberOfUsers() {
		Session session = dbHandler.getSessionFactory().openSession();
		Long size = (Long) session.createQuery("select count(*) from User").uniqueResult();
		return size;
	}
}
