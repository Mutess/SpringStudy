package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.FoodMapper;

@Repository // @Repository은 DAO @Component 일반 클래스
public class FoodDAO {
	@Autowired //구현된 클래스의 주소값을 받음 즉 연관관계를 만드는 중
	private FoodMapper mapper;
	
//	@Select("SELECT fno,name FROM food_house WHERE cno=#{cno}")
	public List<FoodVO> foodCategoryListData(int cno){
		return mapper.foodCategoryListData(cno);
	}
/*	@Select("SELECT fno,name,phone,address,parking,time,menu,price,score "
			+ "FROM food_house "
			+ "WHERE fno=#{fno}")*/
	public FoodVO foodDetailData(int fno) {
		return mapper.foodDetailData(fno);
	}
}
