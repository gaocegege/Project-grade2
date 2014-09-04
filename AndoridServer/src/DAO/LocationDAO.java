package DAO;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Domain.KeyWord;
import Domain.Location;
import Domain.Content;

/**
 * 新闻地点的数据库操作类
 * 
 * @author cece
 *
 */
public class LocationDAO {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void addLocation(Location location) {
		Session session = sessionFactory.openSession();
		// Transaction tx = session.beginTransaction();
		session.beginTransaction();

		if (session.get(KeyWord.class, location.getLid()) == null){
			session.save(location);
			System.out.println(location.getLat()+" "+location.getLng()+" "+location.getProvince());
		}
		// tx.commit();
		session.getTransaction().commit();

		session.close();
	}

	/**
	 * 根据中心坐标，比例尺查找对应的location
	 * 
	 * @author lixu
	 *
	 */
	public List<Object[]> getLocationByAddr(float lat, float lng, float zoom,int bound) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		float nw_lat = lat-10;
		float nw_lng = lng+15;
		float se_lat = lat+10;
		float se_lng = lng-15;
		
		Calendar c = Calendar.getInstance();
		int month = c.get(Calendar.MONTH)+1; 
		int date = c.get(Calendar.DATE);
		String time =month+"月"+date+"日%";

		Query q;
		q = session.createQuery("Select l.lid,l.lat,l.lng,c.title,c.id,c.url From Location l,Domain.Content c Where l.newsContent.id = c.id and l.lat > " + nw_lat
				+ " and l.lat < " + se_lat + " and l.lng > " + se_lng + " and l.lng < " + nw_lng +" and c.time like '"+time+"'");
		System.out.println(q.getQueryString());
		List<Object[]> result = q.list();
		List<String> result2 = q.list();
		System.out.println(result2.toString());
		session.getTransaction().commit();

		session.close();
		return result;
	}
	
	public List<String> getPro(int bound){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Calendar c = Calendar.getInstance();
		int month = c.get(Calendar.MONTH)+1; 
		int date = c.get(Calendar.DATE);
		String time =month+"月"+date+"日%";
		
		Query q;
		q = session.createQuery(" Select l.province From Location l,Domain.Content c Where l.newsContent.id = c.id and c.time like'"+time+"' Group by l.province");
		//q.setMaxResults(200);
		List<String> result = q.list();
		System.out.println(q.toString());
		session.getTransaction().commit();

		session.close();
		return result;
	}
	
	
	public List<Object[]> getLocByPro(String province,int bound){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Calendar c = Calendar.getInstance();
		int month = c.get(Calendar.MONTH)+1; 
		int date = c.get(Calendar.DATE);
		String time =month+"月"+date+"日%";
		
		Query q;
		q = session.createQuery("Select c.title,c.url From Location l,Domain.Content c "
				+ "Where l.newsContent.id = c.id and l.province = '" + province +"' and c.time like '"+time+"'");
		System.out.println(q.toString());
		List<Object[]> result = q.list();
		session.getTransaction().commit();

		session.close();
		return result;
	}
}
