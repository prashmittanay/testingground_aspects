package testing.ground.test;

import java.util.Date;
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
		ht.insertData(ht.getUserBean());
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
	
	
	public void insertData(UserBean userBean){
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(userBean);
		session.getTransaction().commit();
	}
	
	public UserBean getUserBean(){
		UserBean userBean = new UserBean("Checker HB", "hb_check", "abcd", "tester", "checker@nic.in", new Date(), null, 0, "New User");
		return userBean;
	}
}
