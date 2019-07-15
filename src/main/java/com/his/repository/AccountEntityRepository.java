package com.his.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.his.model.AccountEntity;

@Repository
public interface AccountEntityRepository extends CrudRepository<AccountEntity, Integer> {

	@Query(nativeQuery = true, value = "select roles from RoleMaster")
	public List<String> getRole();
	
	
	public List<AccountEntity> findByEmail(String email);

}
