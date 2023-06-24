package com.agus.project.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String home(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        model.addAttribute("username", username);
		model.addAttribute("message","Hello World from Spring MVC + Thymeleaf");
		return "home";
	}
	
	@GetMapping("absensi")
	public String absen() {
		return "Absensi";
	}
	@GetMapping("/chatbot")
	public String chatbot() {
		return "/chatbot";
	}
}
