package com.his.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.his.model.AccountEntity;
import com.his.model.ForgotPassModel;
import com.his.model.LoginModel;
import com.his.repository.AccountEntityRepository;
import com.his.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	AccountEntityRepository accountRepository;

	@Autowired
	EmailServiceImpl emailservice;

	@Override
	public String checkCredintials(LoginModel loginModel) throws Exception {

		String status = "";

		Optional<AccountEntity> entity = accountRepository.getAccountByEmail(loginModel.getUsername().toLowerCase());

		if (entity.isPresent() && loginModel.getUsername().trim().equalsIgnoreCase(entity.get().getEmail())
				&& entity.get().getPassword().equals(loginModel.getPass())) {

			if (entity.get().getStatus().toString().equalsIgnoreCase("N"))
				status = "Your Account is deactivated ! Contact to administration .";
			else if (entity.get().getStatus().toString().equalsIgnoreCase("Y"))
				status = "SUCCESS";
		} else {
			status = "Invalid credintials ! Retry with correct credintials .";
		}

		return status;
	}

	@Override
	public String sendForgottenEmail(ForgotPassModel forgotpass) {
		if (accountRepository.findByEmail(forgotpass.getEmail()).isEmpty()) {
			return "We are facing problem with this " + forgotpass.getEmail() + " id ! Contact to Administrator .";
		} else {
			return emailservice.sendEmailForForgotPass(forgotpass);
		}
	}
}
