package com.his.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.his.model.PlanEntity;
import com.his.model.PlanModel;
import com.his.service.PlanService;

import lombok.NoArgsConstructor;

/**
 * This controller is handling plan creation activity .
 * 
 * @author laksh
 *
 */
@Controller
@RequestMapping("/his")
@NoArgsConstructor
public class PlanController {

	/**
	 * This is a service interface reference variable to dealing with service method
	 * .
	 */
	@Autowired
	private PlanService planService;

	/**
	 * This method shows plan creation page .
	 * 
	 * @param modelMap
	 * @return
	 */
	@GetMapping("/createPlan")
	public String showPlan(final ModelMap modelMap) {
		modelMap.addAttribute("planform", new PlanModel());
		return "planreg";
	}

	/**
	 * This method saves the plan data to persistence layer .
	 * 
	 * @param planModel
	 * @param map
	 * @param attributes
	 * @return
	 */
	@PostMapping("/saveplan")
	public String savePlan(@ModelAttribute("planform") final PlanModel planModel, final ModelMap map,
			final RedirectAttributes attributes) {
		final PlanEntity planEntity = new PlanEntity();
		BeanUtils.copyProperties(planModel, planEntity);
		final String msg = planService.savePalnDetail(planEntity);
		attributes.addFlashAttribute("msg", msg);
		return "redirect:/his/prgforplan";
	}

	/**
	 * This is an PRG method for avoid insertion of duplication of data .
	 * 
	 * @param modelMap
	 * @return
	 */
	@GetMapping("/prgforplan")
	public String prgMethod(final ModelMap modelMap) {
		modelMap.addAttribute("planform", new PlanModel());
		return "planreg";

	}

}
