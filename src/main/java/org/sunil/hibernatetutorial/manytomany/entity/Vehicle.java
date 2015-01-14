package org.sunil.hibernatetutorial.manytomany.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int vehicle_id;
	private String vehicleName;
	@ManyToMany(mappedBy="vehicles")	
	private Collection<UserDetails> listOfUserDetails = new ArrayList<UserDetails>();

	public int getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(int vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	public Collection<UserDetails> getListOfUserDetails() {
		return listOfUserDetails;
	}

	public void setListOfUserDetails(Collection<UserDetails> listOfUserDetails) {
		this.listOfUserDetails = listOfUserDetails;
	}


}
