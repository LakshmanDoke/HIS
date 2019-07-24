package com.his.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.his.model.ForgotPassModel;
import com.his.model.LoginModel;
import com.his.service.AdminService;
import com.his.service.LoginService;

@RestController
@RequestMapping("/his")
public class LoginController {
	@Autowired
	private LoginService loginService;
	@Autowired
	AdminService adminService;

	@GetMapping("/login")
	public ModelAndView showLogin() {
		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("loginform", new LoginModel());
		return modelAndView;
	}

	@PostMapping("/logincheck")
	public ModelAndView checkCredintials(@ModelAttribute("loginform") LoginModel loginModel) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		String checkstatus = loginService.checkCredintials(loginModel);
		if (!checkstatus.equalsIgnoreCase("SUCCESS")) {
			modelAndView.setViewName("login");
			modelAndView.addObject("credintialscheck", checkstatus);
			return modelAndView;
		} else if (checkstatus.equalsIgnoreCase("SUCCESS")) {
			modelAndView.setViewName("dashboard");
			modelAndView.addObject("role", adminService.getAccountByEmail(loginModel.getUsername()).get().getRole());
		}
		modelAndView.setViewName("dashboard");
		return modelAndView;
	}

	@GetMapping("/forgotpass")
	public ModelAndView showForgotPassPage() {
		ModelAndView modelAndView = new ModelAndView("forgotpass");
		modelAndView.addObject("forgotpass", new ForgotPassModel());
		return modelAndView;
	}

	@PostMapping("/forgotpassend")
	public ModelAndView sendForgottenPassword(@ModelAttribute("forgotpass") ForgotPassModel forgotpass) {
		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("loginform", new LoginModel());
		if (loginService.sendForgottenEmail(forgotpass).equalsIgnoreCase("SUCCESS"))
			modelAndView.addObject("credintialscheck", "Email sent successfully check ! Check email.");
		else
			modelAndView.addObject("credintialscheck", "Email failed  ! Something error . Contact Administation .");

		return modelAndView;
	}

}
