package com.his.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.his.model.ApplicationOfPlanEntity;

public interface ApplicationOfPlanEntityRepo extends JpaRepository<ApplicationOfPlanEntity, Integer> {
	@Query(value = "SELECT applicationId FROM ApplicationOfPlanEntity a WHERE a.applicationId= count(applicationId)")
	Integer getApplicationId();

}
