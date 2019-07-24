package com.his.service;

import org.springframework.stereotype.Service;

import com.his.model.PlanEntity;

/**
 * Plan Service interface for plan related stuff.
 * 
 * @author laksh
 *
 */
@Service
public interface PlanService {

	/**
	 * Saves the plan and class impl method .
	 * 
	 * @param planEntity
	 * @return
	 */
	String savePalnDetail(PlanEntity planEntity);

}
