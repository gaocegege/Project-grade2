package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Domain.Content;

/**
 * 新闻条目的数据库操作类
 * @author cece
 *
 */
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
		System.out.println("contentDAO: add Content-> begin");
		Session session = sessionFactory.openSession();
		
		//Test
		
		//Transaction tx = session.beginTransaction();
		session.beginTransaction();
		
		session.save(content);
		
		//tx.commit();
		session.getTransaction().commit();
		
		session.close();
		System.out.println("contentDAO: add Content-> end");
	}
	
	public List<Content> getContents(int id, int types,int method)
	{
		if (id == 0)
		{
			id = getMaxId()+1;
		}
		Session session = sessionFactory.openSession();
		//Transaction tx = session.beginTransaction();
		session.beginTransaction();
		
		Query q;
	    if(method == 0){
	    	q = session.createQuery(" From Content Where id < " + id+ "and types = " + types + "Order by id desc");
	    	q.setFirstResult(0);
	    	q.setMaxResults(20);
	    }else{
	    	q = session.createQuery(" From Content Where id > " + id+ "and types = " + types + "Order by id desc");
	    	System.out.println(id);
	    }
		List<Content> result = q.list();
		//tx.commit();
		session.getTransaction().commit();
		
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
		//Transaction tx = session.beginTransaction();
		session.beginTransaction();
		
		Query q = session.createQuery(" From Content Where id = " + id);
		List<Content> results = q.list();
		if(results.size() == 0)
			return null;
		Content result = results.get(0);
		//tx.commit();
		session.getTransaction().commit();
		session.close();
		return result;
	}
	
	private int getMaxId()
	{
		Session session = sessionFactory.openSession();
		String hql = "select MAX(u.id) from Content as u";
		Query query = session.createQuery(hql);
		List<Integer> result = query.list();
		System.out.println(result.get(0));
		session.close();
		return result.get(0);
	}
	
	public boolean hasContained(String str)
	{
		System.out.println("HasContained in ContentDAO Begin~");
		Session session = sessionFactory.openSession();
		Query q = session.createQuery(" From Content Where title = '" + str + "'");
		List<Content> results = q.list();
		session.close();
		if(results.size() == 0)
		{
			System.out.println("Title: " + str + "\nUse: No");
			System.out.println("HasContained in ContentDAO End~");
			return false;
		}
		else
		{
			System.out.println("Title: " + str + "\nUse: Yes");
			System.out.println("HasContained in ContentDAO End~");
			return true;
		}
	}
}
