package com.his.model;

import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is model class for plan creation .
 * 
 * @author laksh
 *
 */
@Data
@NoArgsConstructor
public class PlanModel {
	@Id
	private Integer planId;
	private String planName;
	private String startDate;
	private String planDesc;
	private String endDate;
}
