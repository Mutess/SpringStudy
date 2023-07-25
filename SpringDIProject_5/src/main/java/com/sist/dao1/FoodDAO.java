package com.sist.dao1;
import java.util.*;

import org.mybatis.spring.support.SqlSessionDaoSupport;
public class FoodDAO extends SqlSessionDaoSupport{
	public List<FoodVO> foodListData(){
		return getSqlSession().selectList("foodListData");
	}
}
