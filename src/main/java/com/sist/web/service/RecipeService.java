package com.sist.web.service;

import java.util.List;

import com.sist.web.vo.RecipeDetailVO;
import com.sist.web.vo.RecipeVO;

public interface RecipeService {

	/*
	 @Select("SELECT no, title, poster, chef "
			+ "FROM recipe "
			+ "WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipeDetail) "
			+ "ORDER BY no ASC "
			+ "OFFSET #{start} ROWS FETCH NEXT 12 ROWS ONLY")
	public List<RecipeVO> recipeListData(int start);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe"
			+ "WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipeDetail)")
	public int recipeTotalPage();
	 */
	
	public List<RecipeVO> recipeListData(int start);
	public int recipeTotalPage();
	public RecipeDetailVO recipeDetailData(int no);
}
