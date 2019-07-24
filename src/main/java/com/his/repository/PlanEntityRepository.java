package com.his.repository;

import org.springframework.data.repository.CrudRepository;

import com.his.model.PlanEntity;
/**
 * This is repository for PlanEntity .
 * @author laksh
 *
 */
public interface PlanEntityRepository extends CrudRepository<PlanEntity, Integer> {

}
