package com.his.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String saveAccount(@ModelAttribute("accountform") AccountModel accountModel, Model model,
			RedirectAttributes attributes) {
		AccountEntity accountEntity = new AccountEntity();
		BeanUtils.copyProperties(accountModel, accountEntity);
		Integer id = accountService.saveAccount(accountEntity);
		attributes.addFlashAttribute("id", "Account" + id + " saved successfully !");
		return "redirect:/his/prgmethod";
	}

	@GetMapping("/prgmethod")
	public String prgMethod(Model model) {
		model.addAttribute("accountform", new AccountModel());
		model.addAttribute("role", accountRepo.getRole());
		return "account";

	}

	@RequestMapping(value = { "/exist/{email}" }, method = RequestMethod.POST)

	public void checkUsername(@PathVariable("email") String email, HttpServletResponse response,
			HttpServletRequest request) throws IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		try {
			List<AccountEntity> emailList = accountRepo.findByEmail(email);

			if (emailList.isEmpty()) {
			} else {
				out.println("<font color=red><b>" + email + "</b> is already in use</font>");
			}
			out.println();

		} catch (Exception ex) {

			out.println("Error ->" + ex.getMessage());

		} finally {
			out.close();
		}

	}

	@GetMapping("/accountdata")
	public ModelAndView showAccountData() {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("acc", accountService.getAllAccount());
		modelAndView.setViewName("accountdata");
		return modelAndView;
	}

}
