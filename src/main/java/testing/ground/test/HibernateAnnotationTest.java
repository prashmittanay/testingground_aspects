package testing.ground.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import testing.ground.beans.SiteBean;

public class HibernateAnnotationTest {
	private SessionFactory sessionFactory;
	
	public static void main(String[] args) {
		HibernateAnnotationTest ht = new HibernateAnnotationTest();
		ht.sessionFactory = new Configuration().configure().buildSessionFactory();
		ht.getAllSites();
		ht.insertSiteData(ht.getSiteBean());
	}
	
	@SuppressWarnings("unchecked")
	public void getAllSites(){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<SiteBean> list = session.createQuery("from SiteBean").list();
		session.close();
		Iterator<SiteBean> iterator = list.iterator();
		
		while (iterator.hasNext()) {
			SiteBean siteBean = (SiteBean) iterator.next();
			System.out.println(siteBean);
		}
	}
	
	
	public void insertSiteData(SiteBean siteBean){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(siteBean);
		session.getTransaction().commit();
	}
	
	public SiteBean getSiteBean(){
		SiteBean siteBean = new SiteBean("http://tester.gov.in", 1, 1, 0);
		return siteBean;
	}
}
