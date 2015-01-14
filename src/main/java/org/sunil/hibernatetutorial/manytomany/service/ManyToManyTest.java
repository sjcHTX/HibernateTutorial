package org.sunil.hibernatetutorial.manytomany.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.sunil.hibernatetutorial.manytomany.entity.UserDetails;
import org.sunil.hibernatetutorial.manytomany.entity.Vehicle;


public class ManyToManyTest {

	public static void main(String[] args) {
		UserDetails user1 = new UserDetails();
		//UserDetails user2 = new UserDetails();
		Vehicle vehicle1 = new Vehicle();
		Vehicle vehicle2 = new Vehicle();
		
		user1.setUserName("First User");
		//user2.setUserName("Second User");
		vehicle1.setVehicleName("car1");
		vehicle1.getListOfUserDetails().add(user1);
		//vehicle1.getListOfUserDetails().add(user2);
		vehicle2.setVehicleName("jeep");
		vehicle2.getListOfUserDetails().add(user1);
		//vehicle2.getListOfUserDetails().add(user2);
		user1.getVehicles().add(vehicle1);
		user1.getVehicles().add(vehicle2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(user1);
		session.save(vehicle1);
		session.save(vehicle2);
		session.getTransaction().commit();
		session.close();
	}
}
