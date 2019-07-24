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
 * Plan Entity class for dealing with persistance class .
 * 
 * @author laksh
 *
 */
@Entity
@Table(name = "PlanMaster")
@NoArgsConstructor
public class PlanEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Setter
	@Getter
	private Integer planId;
	@Setter
	@Getter
	private String planName;
	private String startDate;
	private String endDate;

	@Getter
	@Setter
	private String planDesc;

	public LocalDate getStartDate() {
		return LocalDate.parse(startDate);
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return LocalDate.parse(endDate);
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}