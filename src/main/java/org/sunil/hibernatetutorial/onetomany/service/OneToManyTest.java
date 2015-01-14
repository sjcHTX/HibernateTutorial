package org.sunil.hibernatetutorial.onetomany.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.sunil.hibernatetutorial.onetomany.entity.UserDetails;
import org.sunil.hibernatetutorial.onetomany.entity.Vehicle;

public class OneToManyTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		Vehicle vehicle1 = new Vehicle();
		Vehicle vehicle2 = new Vehicle();
		
		user.setUserName("First User");		
		vehicle1.setVehicleName("car1");
		vehicle1.setUser(user);
		vehicle2.setVehicleName("jeep");
		vehicle2.setUser(user);
		user.getVehicles().add(vehicle1);
		user.getVehicles().add(vehicle2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
//		session.save(user);
//		session.save(vehicle1);
//		session.save(vehicle2);
		session.persist(user);
		session.getTransaction().commit();
		session.close();
	}
}
