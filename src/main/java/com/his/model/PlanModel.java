package com.his.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class PlanModel {
	@Id
	Integer planId;
	String planName;
	String startDate;
	String planDesc;
	String endDate;
}
