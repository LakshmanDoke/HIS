package com.his.service;

import java.util.List;

import com.his.model.ApplicationOfPlanEntity;
import com.his.model.ApplicationOfPlanModel;
import com.his.resources.SSN;

import reactor.core.publisher.Mono;

public interface CaseUserService {

	Mono<SSN> isSsnBelongsToWashingtonState(Integer ssnNo);

	Integer saveApplication(ApplicationOfPlanModel ofPlanModel);

	List<ApplicationOfPlanEntity> getDataTableData();

}
