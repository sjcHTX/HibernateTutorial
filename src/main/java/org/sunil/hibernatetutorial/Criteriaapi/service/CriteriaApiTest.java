package org.sunil.hibernatetutorial.Criteriaapi.service;

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
import org.sunil.hibernatetutorial.Criteriaapi.entity.UserDetails;

public class CriteriaApiTest {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		for (int i = 0; i < 10; i++) {
			UserDetails user = new UserDetails();
			user.setUserName("User " + (i + 1));
			session.save(user);
		}

		
		Criteria criteria = session.createCriteria(UserDetails.class).addOrder(Order.desc("userId"));		
	/*	criteria.add(Restrictions.like("userName", "%User 1%"))
				.add(Restrictions.gt("userId", 0));*/
		
		//criteria.add(Restrictions.or(Restrictions.between("userId", 5, 10), Restrictions.between("userId", 0, 3)));
			
		
		List<UserDetails> users = (List<UserDetails>) criteria.list();
		

		session.getTransaction().commit();
		session.close();
		
		for(UserDetails u : users)
			System.out.println(u.getUserName());
		/*for(String u : userNames)
			System.out.println(u);*/
		/*for(Integer u: users)
			System.out.println(u);*/
	}
}
