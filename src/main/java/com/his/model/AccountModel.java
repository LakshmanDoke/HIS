package com.his.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class AccountModel {
	@Id
	
	Integer acId;
	String firstName;
	String lastName;
	String gender;
	String dob;
	String email;
	String password;
	Integer ssnNo;
	Integer mobileNo;
	String role;

}
