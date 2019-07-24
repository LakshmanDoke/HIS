package com.his.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.his.model.PlanEntity;
import com.his.repository.PlanEntityRepository;
import com.his.service.PlanService;

import lombok.NoArgsConstructor;

/**
 * Implementation of PlanService Interface .
 * 
 * @author laksh
 *
 */
@Service
@NoArgsConstructor
public class PlanServiceImpl implements PlanService {
	/**
	 * PlanRepository reference variable .
	 */
	@Autowired
	private PlanEntityRepository planRepository;

	@Override
	public String savePalnDetail(final PlanEntity planEntity) {
		planRepository.save(planEntity);
		return planEntity.getPlanId() + "    " + planEntity.getPlanName() + " Saved Successsfully !";
	}

}
