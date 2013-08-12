package testing.ground.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
		List list = session.createQuery("from UserBean").list();
		System.out.println(list);
		session.close();
	}
	
	
	
}
