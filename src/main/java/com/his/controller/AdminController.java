package com.his.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.his.model.AccountEntity;
import com.his.model.AccountModel;
import com.his.repository.AccountEntityRepository;
import com.his.service.AdminService;
import com.his.util.AppConstantHelper;

import lombok.NoArgsConstructor;

/****
 * 
 * @author laksh This is the class Handles all Account Related stuff .
 *
 */
@Controller
@RequestMapping("/his")
@NoArgsConstructor
public class AdminController {
	/**
	 * Account service reference variable for dealing with Business Service .
	 */
	@Autowired
	private AdminService accountService;

	/**
	 * Reference variable of AccountEntityRepository for persistence layer .
	 */
	@Autowired
	private AccountEntityRepository accountRepo;

	/**
	 * Logger reference variable .
	 */
	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * This method shows AccountRegistration page .
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/acregister")
	public ModelAndView accountRegister(final ModelMap model) {
		LOGGER.debug("Display Account Registration form started  ..........");
		ModelAndView view = new ModelAndView("account");
		view.addObject("accountform", new AccountModel());
		view.addObject("role", accountRepo.getRole());
		LOGGER.debug("Display Account Registration form completed ");
		LOGGER.info("Display Account registration successful ");
		return view;
	}

	/**
	 * This method saves the account in database and returns the id of saved account
	 * and redirect to PGR(Post Gate Request) method to restrict data insertion on
	 * refresh page.
	 * 
	 * @param accountModel
	 * @param model
	 * @param attributes
	 * @return
	 * @throws Exception 
	 */
	@PostMapping("/saveacc")
	public String saveAccount(final @ModelAttribute("accountform") AccountModel accountModel, final Model model,
			final RedirectAttributes attributes) throws Exception {
		LOGGER.debug("The account data saving , saveAccount() started execution ");
		final AccountEntity accountEntity = accountService.saveAccount(accountModel);
		attributes.addFlashAttribute("id",
				"Account" + accountEntity.getAcId() + "  " + accountEntity.getFirstName() + " saved successfully !");
		LOGGER.debug("The account data saving , saveAccount() ended execution ");
		return "redirect:/his/prgmethod";
	}

	/**
	 * This is PRG method which restrict duplicate data when user refresh the page.
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/prgmethod")
	public String prgMethod(final Model model) {
		LOGGER.debug("Redirecting to account page, prgMethod() started execution ");
		model.addAttribute("accountform", new AccountModel());
		model.addAttribute("role", accountRepo.getRole());
		LOGGER.debug("Redirecting to account page, prgMethod() ended execution ");
		return "account";

	}

	/**
	 * This method check the email available or not by using ajax and avoid
	 * duplicate email .
	 * 
	 * @param email
	 * @param response
	 * @param request
	 * @throws IOException
	 */
	@PostMapping("/exist/{email}")
	public void checkUsername(final @PathVariable("email") String email, final HttpServletResponse response,
			final HttpServletRequest request) throws IOException {
		LOGGER.debug("Checking email is available or not , checkUsername() started execution ");
		response.setContentType("text/html;charset=UTF-8");

		try (PrintWriter out = response.getWriter()) {
			if (!accountRepo.findByEmail(email).isEmpty()) {
				out.println("<font color=red><b>" + email + "</b> is already in use</font>");
			}
		}
		LOGGER.debug("Checking email is available or not , checkUsername() ended execution ");
	}

	/**
	 * It is an soft delete method . It change status Y to N and N to Y.
	 * 
	 * @param email
	 * @param response
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@GetMapping("/activateCwProfile/{status}")
	public String updateAccountStatusActivate(final @PathVariable("status") String email) {
		LOGGER.error("Update status ............");
		Integer a = accountService.updateStatus(AppConstantHelper.ACTIVE_STATUS, email);
		LOGGER.error("Update status" + a);
		return "redirect:/his/accountdata";
	}

	@GetMapping("/deleteCwProfile/{status}")
	public String updateAccountStatusDeactivate(final @PathVariable("status") String email) {
		accountService.updateStatus(AppConstantHelper.INACTIVE_STATUS, email);
		return "redirect:/his/accountdata";
	}

	/***
	 * This method shows account data in table .
	 * 
	 * @return
	 */
	@GetMapping("/accountdata")
	public ModelAndView showAccountData() {
		final ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("acc", accountService.getAllAccount());
		modelAndView.setViewName("accountdata");
		return modelAndView;
	}
}
