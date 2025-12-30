package com.sist.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class RecipeController {
	
	@GetMapping("/list")
	public String main_page() {
		
		return "recipe/list";
	}
}
