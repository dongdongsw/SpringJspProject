package com.sist.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.RecipeDetailVO;
import com.sist.web.vo.RecipeVO;

@Mapper
@Repository
public interface RecipeMapper {
	
	// 목록
	@Select("SELECT no, title, poster, chef "
			+ "FROM recipe "
			+ "WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipeDetail) "
			+ "ORDER BY no ASC "
			+ "OFFSET #{start} ROWS FETCH NEXT 12 ROWS ONLY")
	public List<RecipeVO> recipeListData(int start);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe "
			+ "WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipeDetail)")
	public int recipeTotalPage();
	
	// 상세보기
	@Update("UPDATE recipe SET "
			+ "hit = hit + 1 "
			+ "WHERE no = #{no}")
	public void recipeHitIncrement(int no);
	
	@Select("SELECT * FROM recipeDetail "
			+ "WHERE no = #{no}")
	public RecipeDetailVO recipeDetailData(int no);
	
	// 댓글 : Mapper => Service에 통합
}
