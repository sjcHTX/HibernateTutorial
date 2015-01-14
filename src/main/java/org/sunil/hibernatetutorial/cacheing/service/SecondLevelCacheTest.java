package org.sunil.hibernatetutorial.cacheing.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.sunil.hibernatetutorial.cacheing.entity.UserDetails;


public class SecondLevelCacheTest {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
/*		UserDetails user = (UserDetails) session.get(UserDetails.class, 1);
		user.setUserName("Updated User");
		UserDetails user2 = (UserDetails) session.get(UserDetails.class, 1);
		System.out.println(user2.getUserName());*/
		
		Query query = session.createQuery("from UserDetails user where user.userId = 1");
		query.setCacheable(true);
		List<UserDetails> users = (List<UserDetails>) query.list(); 
			
		session.getTransaction().commit();
		session.close();
		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		
/*		UserDetails user3 = (UserDetails) session2.get(UserDetails.class, 1);*/
		Query query2 = session2.createQuery("from UserDetails user where user.userId = 1");
		query2.setCacheable(true);
		users = query2.list();
		session2.getTransaction().commit();
		session2.close();
		
		/*System.out.println(user3.getUserName());*/
		/*for(UserDetails u : users)
			System.out.println(u.getUserName()); */
		/*for(String u : userNames)
			System.out.println(u);*/
		/*for(Integer u: users)
			System.out.println(u);*/
	}
}
