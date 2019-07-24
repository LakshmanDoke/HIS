package com.his.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This is entity class for account data handling .
 * 
 * @author laksh
 *
 */
@Entity
@Table(name = "AccountMaster")
@NoArgsConstructor
public class AccountEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
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
	@Getter
	@Setter
	private Character status;

	public Integer getAcId() {
		return acId;
	}

	public void setAcId(Integer acId) {
		this.acId = acId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return LocalDate.parse(dob);
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public Long getSsnNo() {
		return ssnNo;
	}

	public void setSsnNo(final Long ssnNo) {
		this.ssnNo = ssnNo;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
