package com.his.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.his.exception.EmailAvailableException;
import com.his.model.AccountEntity;
import com.his.model.AccountModel;
import com.his.repository.AccountEntityRepository;
import com.his.service.AdminService;
import com.his.service.EmailService;
import com.his.util.AppConstantHelper;
import com.his.util.PasswordEncryptDecryptUtil;

import lombok.NoArgsConstructor;

/**
 * Admin Service implementation class .
 * 
 * @author laksh
 *
 */
@Service
@NoArgsConstructor
public class AdminServiceImpl implements AdminService {
	/**
	 * Repository reference variable for dealing with repository .
	 */
	@Autowired
	private AccountEntityRepository accountRepo;

	/**
	 * Email service interface reference variable . To call email related stuff .
	 */
	@Autowired
	private EmailService emailService;

	@Override
	public Iterable<AccountEntity> getAllAccount() {

		return accountRepo.findAll();
	}

	@Override
	@Transactional
	public AccountEntity saveAccount(final AccountModel accountModel) throws Exception {

		AccountEntity accountEntity = new AccountEntity();

		BeanUtils.copyProperties(accountModel, accountEntity);

		accountEntity.setPassword(PasswordEncryptDecryptUtil.getEncryptedPassword(accountEntity.getPassword()));
		accountEntity.setStatus(AppConstantHelper.ACTIVE_STATUS);
		accountEntity.setEmail(accountEntity.getEmail().toLowerCase());

		if (accountRepo.findByEmail(accountEntity.getEmail()).isEmpty()) {
			accountEntity = accountRepo.save(accountEntity);
			accountEntity.setPassword(PasswordEncryptDecryptUtil.getDecryptedPassword(accountEntity.getPassword()));
			emailService.sendEmail(accountEntity);
		} else {
			throw new EmailAvailableException(accountEntity.getEmail());
		}
		return accountEntity;
	}

	@Override
	@Transactional
	public int updateStatus(final Character statusChar, final String email) {
		return accountRepo.updateStatus(statusChar, email);
	}

	@Override
	public Optional<AccountEntity> getAccountByEmail(String email) {
		return accountRepo.getAccountByEmail(email);
	}

}
