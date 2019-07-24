package com.his.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.NoArgsConstructor;

/**
 * This controller is for menu in home page.
 * 
 * @author laksh
 *
 */
@NoArgsConstructor
@Controller
@RequestMapping("/his")
public class HomeController {
	/**
	 * It shows home page.
	 * 
	 * @return
	 */
	@GetMapping("/")
	public String showHomePage() {
		return "home";
	}

	/**
	 * It shows service page.
	 * 
	 * @return
	 */
	@GetMapping("/service")
	public String showService() {
		return "service";
	}

	/**
	 * It shows about page.
	 * 
	 * @return
	 */
	@GetMapping("/about")
	public String showAbout() {
		return "about";
	}

	/**
	 * It shows testimonial page.
	 * 
	 * @return
	 */
	@GetMapping("/testimonial")
	public String showTestimonial() {
		return "testimonial";
	}

	/**
	 * It shows contact page.
	 * 
	 * @return
	 */
	@GetMapping("/contact")
	public String showContact() {
		return "contact";
	}
}
