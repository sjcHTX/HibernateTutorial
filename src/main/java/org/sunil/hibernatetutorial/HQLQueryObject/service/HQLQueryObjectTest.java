package org.sunil.hibernatetutorial.HQLQueryObject.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HQLQueryObjectTest {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

/*		for (int i = 0; i < 10; i++) {
			UserDetails user = new UserDetails();
			user.setUserName("User " + (i + 1));
			session.save(user);
		}*/

		Query query = session.createQuery("select userName from UserDetails");
		query.setFirstResult(5);
		query.setMaxResults(4);
		//List<UserDetails> users = (List<UserDetails>) query.list();
		List<String> userNames = (List<String>) query.list();

		session.getTransaction().commit();
		session.close();
		
		/*for(UserDetails u : users)
			System.out.println(u.getUserName());*/
		for(String u : userNames)
			System.out.println(u);
	}
}
