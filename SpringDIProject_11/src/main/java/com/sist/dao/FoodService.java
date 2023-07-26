package com.sist.dao;
/*
	DAO와 Service의 차이점
	단독으로 사용하면 DAO
	DAO를 합쳐서 사용하면 Service
	
	XML : 여러명이 동시에 사용
	Annotation : 개인이 사용이 가능
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {
	@Autowired
	private FoodDAO fdao;
	@Autowired
	private CategoryDAO cdao;
	
	public List<CategoryVO> cateListData(){
		return cdao.cateListData();
	}
	public List<FoodVO> foodCategoryListData(int cno){
		return fdao.foodCategoryListData(cno);
	}
	
	public FoodVO foodDetailData(int fno) {
		return fdao.foodDetailData(fno);
	}
}
