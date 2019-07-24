package com.his.service;

import java.io.IOException;
import java.util.Optional;

import com.his.exception.EmailAvailableException;
import com.his.model.AccountEntity;
import com.his.model.AccountModel;

/**
 * This is an service interface for AdminController .
 * 
 * @author laksh
 *
 */
public interface AdminService {
	/**
	 * It saves account .
	 * 
	 * @param accountModel
	 * @return
	 * @throws IOException
	 * @throws EmailAvailableException
	 * @throws Exception
	 */
	AccountEntity saveAccount(AccountModel accountModel) throws IOException, EmailAvailableException, Exception;

	/**
	 * It gets all account from database table .
	 * 
	 * @return
	 */
	Iterable<AccountEntity> getAllAccount();

	/**
	 * This method update the status active / inactive .
	 * 
	 * @param statusChar
	 * @param email
	 * @return
	 */
	int updateStatus(Character statusChar, String email);

	Optional<AccountEntity> getAccountByEmail(String email);
}
