package com.sist.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {

	@GetMapping("/member/login")
	public String member_login() {
		
		return "member/login";
	}
	
	@GetMapping("/member/logout")
	public String member_logout(HttpSession session) {
		
		session.invalidate();
		
		return "recipe/list";
	}
}
