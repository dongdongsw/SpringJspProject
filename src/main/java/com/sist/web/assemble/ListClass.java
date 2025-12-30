package com.sist.web.assemble;

import java.util.HashMap;
import java.util.Map;

public class ListClass {

	final static int BLOCK = 10;
	
	public static Map<String, Integer> pages(int page, int totalpage) {
		int startPage = ((page-1)/BLOCK*BLOCK)+1;
		int endPage = ((page-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage > totalpage) {
			endPage = totalpage;
		}
		
		Map map = new HashMap<>();
		
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("totalpage", totalpage);
		
		return map;
	}
	
}
