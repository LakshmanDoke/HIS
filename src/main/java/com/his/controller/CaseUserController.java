package com.his.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.his.model.ApplicationOfPlanModel;
import com.his.resources.SSN;
import com.his.service.CaseUserService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/his")
public class CaseUserController {

	@Autowired
	CaseUserService caseUserService;

	@GetMapping("/applicationforplan")
	public ModelAndView showApplicationForm() {
		ModelAndView modelAndView = new ModelAndView("applicationforplan");
		modelAndView.addObject("applicationforplan", new ApplicationOfPlanModel());
		return modelAndView;
	}

	@PostMapping("/saveapplicationofplan")
	public ModelAndView saveApplicationOfPlan(@ModelAttribute("applicationforplan") ApplicationOfPlanModel ofPlanModel,
			RedirectAttributes attributes) {
		ModelAndView modelAndView = new ModelAndView("redirect:/his/applicationforplan");

		Mono<SSN> ssnBelongToState = caseUserService.isSsnBelongsToWashingtonState(ofPlanModel.getSsnNo().intValue());
		if (ssnBelongToState.block().getState().equalsIgnoreCase("Washington")) {
			Integer applicationId = caseUserService.saveApplication(ofPlanModel);
			attributes.addFlashAttribute("msg", applicationId + " saved successfully !");
		} else {
			attributes.addFlashAttribute("msg",
					"<font color='red'>" + ofPlanModel.getSsnNo() + " is not belongs to Washington state  !</font>");
		}

		return modelAndView;
	}

	@GetMapping("/applicationdatatable")
	public ModelAndView showApplicationDataTable() {
		ModelAndView modelAndView = new ModelAndView("appicationdatatablepage");
		modelAndView.addObject("data", caseUserService.getDataTableData());
		return modelAndView;

	}
}
