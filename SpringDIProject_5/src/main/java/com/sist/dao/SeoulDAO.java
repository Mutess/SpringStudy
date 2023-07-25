package com.sist.dao;

import java.util.*;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class SeoulDAO extends SqlSessionDaoSupport{
	public List<Seoul_locationVO> seoulListData(Map map){
		return getSqlSession().selectList("seoulListData",map);
	}
	
	public int seoulTotalPage() {
		return getSqlSession().selectOne("seoulTotalPage");
	}
	
	public List<Seoul_locationVO> seoulFindData(String title){
		return getSqlSession().selectList("seoulFindData",title);
	}
}
