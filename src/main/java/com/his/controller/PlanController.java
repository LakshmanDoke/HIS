package com.his.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.his.model.PlanModel;

@Controller
@RequestMapping("/his")
public class PlanController {
	@GetMapping("/createPlan")
	public String showPlan(ModelMap modelMap) {
		modelMap.addAttribute("planform", new PlanModel());
		return "planreg";
	}
}
