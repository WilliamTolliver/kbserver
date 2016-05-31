package com.wttechnologies.spring.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

	@RequestMapping("/home")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "To Home!") String name,
			Model model) {
		model.addAttribute("name", name);
		return "home";
	}

}