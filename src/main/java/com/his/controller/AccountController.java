package com.his.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.his.model.AccountEntity;
import com.his.model.AccountModel;
import com.his.repository.AccountEntityRepository;
import com.his.service.AccountService;

@Controller
@RequestMapping("/his")
public class AccountController {
	@Autowired
	AccountService accountService;

	@Autowired
	AccountEntityRepository accountRepo;

	@GetMapping("/acregister")
	public String accountRegister(Model model) {
		model.addAttribute("accountform", new AccountModel());
		model.addAttribute("role", accountRepo.getRole());
		return "account";
	}

	@PostMapping("/saveacc")
	public String saveAccount(@ModelAttribute("accountform") AccountModel accountModel, Model model) {
		AccountEntity accountEntity = new AccountEntity();
		BeanUtils.copyProperties(accountModel, accountEntity);
		accountService.saveAccount(accountEntity);

		return "account";
	}
}
