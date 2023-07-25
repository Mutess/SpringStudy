package com.sist.dao;

import java.util.*;

import org.mybatis.spring.support.SqlSessionDaoSupport;
public class EmpDAO extends SqlSessionDaoSupport {
	public List<EmpVO> empListData(){
		return getSqlSession().selectList("empListData"); //empListData를 emp-mapper.xml에서 id값을 찾아서 list에 모아줌
	}
	public EmpVO empDetailData(int empno) {
		return getSqlSession().selectOne("empDetailData",empno);
	}
}
