package DAO;

import java.util.List;

import org.hibernate.Query;
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
		if (session.get(Content.class, content.getId()) == null)
			session.save(content);
		tx.commit();
		session.close();
	}
	
	public List<Content> getContents(int id)
	{
		if (id == 0)
		{
			id = getMaxId();
		}
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery(" From Content where id < " + id + "and id > " + (id - 11));
		q.setFirstResult(0);
		q.setMaxResults(10);
		List<Content> result = q.list();
		tx.commit();
		session.close();
		return result;
	}
	
	private int getMaxId()
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "select MAX(u.id) from Content as u";
		Query query = session.createQuery(hql);
		List<Integer> result = query.list();
		System.out.println(result.get(0));
		return result.get(0);
	}
}
