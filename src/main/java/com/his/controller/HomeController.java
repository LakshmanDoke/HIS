package com.his.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ Controller
@RequestMapping("/his")
public class HomeController {
	@GetMapping("/")
	public String showHomePage() {
		return "home";
	}

	@GetMapping("/service")
	public String showService() {
		return "service";
	}

	@GetMapping("/about")
	public String showAbout() {
		return "about";
	}

	@GetMapping("/testimonial")
	public String showTestimonial() {
		return "testimonial";
	}

	@GetMapping(value = "/contact"  )
	public String showContact() {
		return "contact";
	}
}
