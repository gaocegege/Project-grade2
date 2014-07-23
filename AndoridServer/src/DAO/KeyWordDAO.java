package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Domain.Content;
import Domain.KeyWord;

import com.opensymphony.xwork2.ActionSupport;

public class KeyWordDAO extends ActionSupport {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void addKeyWord(KeyWord keyWord)
	{
		Session session = sessionFactory.openSession();
		//Transaction tx = session.beginTransaction();
		session.beginTransaction();
		
		if (session.get(KeyWord.class, keyWord.getKid()) == null)
			session.save(keyWord);
		//tx.commit();
		session.getTransaction().commit();
		
		session.close();
	}
}
