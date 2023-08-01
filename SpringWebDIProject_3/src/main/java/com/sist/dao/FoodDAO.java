package com.sist.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import java.util.*;
@Repository
public class FoodDAO extends SqlSessionDaoSupport {

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	/*
				SELECT cno,title,poster,subject
				FROM food_category
				WHERE
		<!-- 		<if test="cno==1">  //여기서 cno는 키이름 키안에 속성을 읽음
				cno BETWEEN 1 AND 12
				</if>
				<if test="cno==2">
				cno BETWEEN 13 AND 18
				</if>
				<if test="cno==3">
				cno BETWEEN 19 AND 30
				</if> -->  동적쿼리 => 조건에 따라 보여지는걸 다르게 하는 것
	 */
	public List<CategoryVO> categoryListData(Map map){ //MyBatis는 제네릭은 자동으로 맞춰줌 (즉, 어댑터 패턴)
		return getSqlSession().selectList("categoryListData",map);
	}
	
}
