package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;
import com.sist.mapper.FoodMapper;
@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	
	public List<CategoryVO> foodCategoryListData(Map map){
		return mapper.foodCategoryListData(map);
	}
	
	//<select id="foodCategoryInfoData" resultType="CategoryVO" parameterType="int">
		public CategoryVO foodCategoryInfoData(int cno) {
			return mapper.foodCategoryInfoData(cno);
		}
		
		//<select id="foodListData" resultType="FoodVO" parameterType="int">
		public List<FoodVO> foodListData(int cno){
			return mapper.foodListData(cno);
		}
		
		public FoodVO foodDetailData(int fno) {
			return mapper.foodDetailData(fno);
		}
}
