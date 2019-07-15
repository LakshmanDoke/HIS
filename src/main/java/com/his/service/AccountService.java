package com.his.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.his.model.AccountEntity;

@Service
public interface AccountService {
	@Transactional
	Integer saveAccount(AccountEntity accountEntity);

	public Iterable<AccountEntity> getAllAccount();

}
