package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Domain.KeyWord;
import Domain.Location;

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
	public List<Location> getLocationByAddr(float lat, float lng, float zoom) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		float nw_lat = lat-30;
		float nw_lng = lng+50;
		float se_lat = lat+30;
		float se_lng = lng-50;

		Query q;
		q = session.createQuery(" From Location Where lat > " + nw_lat
				+ " and lat < " + se_lat + " and lng > " + se_lng + " and lng < "
				+ nw_lng);
		System.out.println(q.getQueryString());
		List<Location> result = q.list();
		session.getTransaction().commit();

		session.close();
		return result;
	}
}
