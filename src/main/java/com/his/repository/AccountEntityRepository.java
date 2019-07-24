package com.his.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.his.model.AccountEntity;

/**
 * This repository for account creation .Dealing with DB . Uses SPring data JPA
 * feature .
 * 
 * @author laksh
 *
 */
@Repository
public interface AccountEntityRepository extends JpaRepository<AccountEntity, Integer> {

	/**
	 * It select roles from RoleMaster and gives to account creation page for drop
	 * down state .
	 * 
	 * @return
	 */
	@Query(nativeQuery = true, value = "select roles from RoleMaster")
	List<String> getRole();

	/**
	 * It returns the list of all email id's .
	 * 
	 * @param email
	 * @return
	 */
	List<AccountEntity> findByEmail(String email);

	/**
	 * It update the status of account is it active or inactive .
	 * 
	 * @param n
	 * @param email
	 * @return
	 */
	@Modifying(clearAutomatically = true)
	@Query("UPDATE AccountEntity c SET c.status = :statusChar where c.email= :email")
	int updateStatus(Character statusChar, String email);
	
	
	@Query(" FROM  AccountEntity a where a.email= :email")
	Optional<AccountEntity> getAccountByEmail(String email);
	
}













