package testing.ground.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import testing.ground.beans.UserBean;

public class HibernateTest {
	private SessionFactory sessionFactory;
	
	public static void main(String[] args) {
		HibernateTest ht = new HibernateTest();
		ht.sessionFactory = new Configuration().configure().buildSessionFactory();
		ht.getData();
	}
	
	public void getData(){
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<UserBean> list = session.createQuery("from UserBean").list();
		Iterator<UserBean> iterator = list.iterator();
		
		while (iterator.hasNext()) {
			UserBean userBean = (UserBean) iterator.next();
			System.out.println(userBean);
		}
		session.close();
	}
	
	
	
}
