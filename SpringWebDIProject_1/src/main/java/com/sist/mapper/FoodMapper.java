package com.sist.mapper;

import java.util.*;

              
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

import com.sist.vo.*;
public interface FoodMapper {
	@Autowired
	@Select("SELECT cno,title,poster,subtitle "
			+ "FROM food_category "
			+ "ORDER BY cno ASC")
	public List<CategoryVO> foodCategoryListData();
	
	@Select("SELECT fno,name,score,address,phone,type,poster "
			+ "FROM food_house "
			+ "WHERE cno=#{cno}")
	public List<FoodVO> foodListData(int cno);
	
	@Select("SELECT title, subtitle "
			+ "FROM food_category "
			+ "WHERE cno=#{cno}")
	public CategoryVO foodCategoryInfoData(int cno);
}
