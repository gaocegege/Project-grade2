package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Domain.Content;
import Domain.NewsContent;

public class NewsContentDAO {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public NewsContent getNewsContent(int id)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery(" From NewsContent Where id = " + id);
		List<NewsContent> results = q.list();
		if(results.size() == 0)
			return null;
		NewsContent result = results.get(0);
		tx.commit();
		session.close();
		return result;
	}
}
