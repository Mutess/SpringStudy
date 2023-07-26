package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.CategoryMapper;

// @Repository은 DAO @Component 일반 클래스
@Repository
public class CategoryDAO {
	@Autowired //구현된 클래스의 주소값을 받음
	private CategoryMapper mapper;
	
/*	public interface CategoryMapper {
		@Select("SELECT cno,title,subtitle "
			  + "FROM food_category "
			  + "ORDER BY cno ASC")*/
		public List<CategoryVO> cateListData(){
			return mapper.cateListData();
		}
}
