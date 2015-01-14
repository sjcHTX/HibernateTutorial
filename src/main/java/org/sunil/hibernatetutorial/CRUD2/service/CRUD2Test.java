package org.sunil.hibernatetutorial.CRUD2.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.sunil.hibernatetutorial.CRUD2.entity.UserDetails;

public class CRUD2Test {

	public static void main(String[] args) {
		
		UserDetails user = new UserDetails();
		user.setUserName("Test User");

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
			
		session.save(user);
		
		user.setUserName("Updated User");
		user.setUserName("Updated User Again");
		

		session.getTransaction().commit();
		session.close();
		
		user.setUserName("Updated User Again After Close");
	}
}
