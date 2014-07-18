package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Domain.Content;


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
	
	public List<Content> getContents(int id, int types,int method)
	{
		if (id == 0)
		{
			id = getMaxId();
		}
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query q;
	    if(method == 0){
	    	q = session.createQuery(" From Content Where id < " + id+ "and types = " + types + "Order by id desc");
	    	q.setFirstResult(0);
	    	q.setMaxResults(20);
	    }else{
	    	q = session.createQuery(" From Content Where id > " + id+ "and types = " + types + "Order by id desc");
	    }
		List<Content> result = q.list();
		tx.commit();
		session.close();
		return result;
	}
	
	public Content getOneContent(int id)
	{
		if (id == 0)
		{
			id = getMaxId();
		}
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery(" From Content Where id = " + id);
		List<Content> results = q.list();
		if(results.size() == 0)
			return null;
		Content result = results.get(0);
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
