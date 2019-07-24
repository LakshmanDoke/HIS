package com.his.model;

import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is an model class for account creation .
 * 
 * @author laksh
 *
 */
@Data
@NoArgsConstructor
public class AccountModel {
	@Id
	private Integer acId;
	private String firstName;
	private String lastName;
	private String gender;
	private String dob;
	private String email;
	private String password;
	private Long ssnNo;
	private Long mobileNo;
	private String role;
	private Character status;
}
