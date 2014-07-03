package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import domain.Content;

public class ContentDAO {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}  
	
	public void addContent(Content content)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(content);
		tx.commit();
		session.close();
	}
}
