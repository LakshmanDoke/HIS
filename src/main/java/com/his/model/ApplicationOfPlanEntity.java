package com.his.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "AppliationOfPlan_Master")
@Data
public class ApplicationOfPlanEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "applgenerator")
	@SequenceGenerator(name = "applgenerator", allocationSize = 1, initialValue = 1254)
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
