package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Domain.KeyWord;
import Domain.Location;

public class LocationDAO {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void addLocation(Location location)
	{
		Session session = sessionFactory.openSession();
		//Transaction tx = session.beginTransaction();
		session.beginTransaction();
		
		if (session.get(KeyWord.class, location.getLid()) == null)
			session.save(location);
		//tx.commit();
		session.getTransaction().commit();
		
		session.close();
	}
}
