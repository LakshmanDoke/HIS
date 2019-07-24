package com.his.model;

import java.io.Serializable;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import com.his.repository.ApplicationOfPlanEntityRepo;

public class ApplIdGenerator implements IdentifierGenerator {
	@Autowired
	ApplicationOfPlanEntityRepo appRepo;

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) {
		String prefix = "HISAP";
		Integer id = appRepo.getApplicationId();
		if (id != null)
			return prefix + id.toString();

		return null;
	}

}
