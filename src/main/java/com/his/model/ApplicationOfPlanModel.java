package com.his.model;

import java.time.LocalDate;

import javax.persistence.Id;

import lombok.Data;

@Data
public class ApplicationOfPlanModel {
	@Id
	Integer applicationId;
	private String firstName;
	private String lastName;
	private String gender;
	private String dob;
	private String email;
	private Long ssnNo;
	private Long mobileNo;
	private LocalDate appliedDate;
}
