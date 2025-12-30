package com.sist.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.web.vo.RecipeVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService{
	
	
	@Override
	public List<RecipeVO> recipeListData(int start) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int recipeTotalPage() {
		// TODO Auto-generated method stub
		return 0;
	}

}
