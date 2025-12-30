package com.sist.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.assemble.ListClass;
import com.sist.web.service.RecipeService;
import com.sist.web.vo.RecipeDetailVO;
import com.sist.web.vo.RecipeVO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recipe")
public class RecipeRestController {

	private final RecipeService rService;
	
	
	@GetMapping("/list_vue/")
	public ResponseEntity<Map> recipe_list_vue(@RequestParam("page") int page){
		
		List<RecipeVO> list = null;
		Map map = new HashMap<>();
		try {
			
			list = rService.recipeListData(page);
			int totalpage = rService.recipeTotalPage();
			
			map.put("list", list);
			map.put("curpage", page);
			map.putAll(ListClass.pages(page, totalpage));
			
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	@GetMapping("/detail_vue/")
	public ResponseEntity<Map> recipe_detail_vue(@RequestParam("no") int no){
		
		Map map = new HashMap<>();
		List<String> tList = new ArrayList<String>();
		List<String> iList = new ArrayList<String>();
		try {
			RecipeDetailVO vo = rService.recipeDetailData(no);
			String[] datas = vo.getFoodmake().split("\n");
			
			for(String s : datas) {
				StringTokenizer st = new StringTokenizer(s,"^");
				tList.add(st.nextToken());
				iList.add(st.nextToken());
			}
			map.put("vo", vo);
			map.put("tList", tList);
			map.put("iList", iList);
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	return new ResponseEntity<>(map, HttpStatus.OK);
	}
}
