package com.sist.web.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.service.MemberService;
import com.sist.web.vo.MemberVO;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberRestController {

	private final MemberService mService;
	
	@GetMapping("/login_vue/")
	public ResponseEntity<MemberVO> member_login_vue(@RequestParam("id") String id, @RequestParam("pwd") String pwd
			,HttpSession session){
		
		MemberVO vo = new MemberVO();
		
		try {
			vo = mService.isLogin(id, pwd);
			if(vo.getMsg().equals("OK")) {
				session.setAttribute("id", vo.getId());
				session.setAttribute("name", vo.getName());
			}
			
		} catch (Exception ex) {
			
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(vo, HttpStatus.OK);
	}
}
