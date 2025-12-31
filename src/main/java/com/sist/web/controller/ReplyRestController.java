package com.sist.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.service.ReplyService;
import com.sist.web.vo.ReplyVO;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reply")
public class ReplyRestController {

	private final ReplyService rService;
	
	public Map commonsListData(int cno, int type){
		Map map = new HashMap<>();
		List<ReplyVO> list = rService.replyListData(cno, type);
		map.put("list", list);
		map.put("cno", cno);
		map.put("type", type);
		
		return map;
	}
	
	
	@GetMapping("/list_vue/")
	public ResponseEntity<Map> reply_list_vue(@RequestParam("cno") int cno, @RequestParam("type") int type){
		
		Map map = new HashMap<>();
		List<ReplyVO> list = null;
		try {
			map = commonsListData(cno,type);
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(map,  HttpStatus.OK);
	}
	
	@PostMapping("/insert_vue/")
	public ResponseEntity<Map> reply_insert_vue(@RequestBody ReplyVO vo, HttpSession session){
		
		Map map = new HashMap<>();
		List<ReplyVO> list = null;
		try {
			String id = (String)session.getAttribute("id");
			String name = (String)session.getAttribute("name");
			
			vo.setId(id);
			vo.setName(name);
			
			rService.replyInsert(vo);
			
			map = commonsListData(vo.getCno(),vo.getType());
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(map,  HttpStatus.OK);
	}
	
	@DeleteMapping("/delete_vue/")
	public ResponseEntity<Map> reply_delete_vue(
			@RequestParam("no") int no,
			@RequestParam("cno") int cno, 
			@RequestParam("type") int type){

		Map map = new HashMap<>();
		List<ReplyVO> list = null;
		try {
			rService.replyDelete(no);
			
			map = commonsListData(cno,type);
			
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(map,  HttpStatus.OK);
	}
	
	@PutMapping("/update_vue/")
	public ResponseEntity<Map> reply_update_vue(@RequestBody ReplyVO vo){
		
		Map map = new HashMap<>();
		List<ReplyVO> list = null;
		try {
			
			
			rService.replyUpdate(vo);
			
			map = commonsListData(vo.getCno(),vo.getType());
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(map,  HttpStatus.OK);
	}
}
