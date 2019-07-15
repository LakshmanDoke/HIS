package com.his.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.his.model.AccountEntity;
import com.his.repository.AccountEntityRepository;
import com.his.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountEntityRepository accountEntityRepository;

	@Override
	public Integer saveAccount(AccountEntity accountEntity) {
		accountEntityRepository.save(accountEntity);
		return accountEntity.getAcId();
	}

	@Override
	public Iterable<AccountEntity> getAllAccount() {

		return accountEntityRepository.findAll();
	}

}
