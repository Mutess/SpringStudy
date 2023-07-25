package com.sist.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
public class ShopDAO extends SqlSessionDaoSupport{
	
	/*
		<sql id="select-sql">
		SELECT no,title,address,msg
		FROM seoul_Shop
		</sql>
		<select id="ShopListData" resultType="SeoulShopVO">
			SELECT no,title,address,msg,rownum
			FROM (SELECT no,title,address,msg FROM seoul_shop ORDER BY no ASC)
			WHERE rownum &lt;=10
		</select>
		<select id="ShopDetailData" resultType="SeoulShopVO" parameterType="int">
			<include refid="select-sql"/>
			WHERE no=#{no}
		</select>
	 */
	public List<SeoulShopVO> ShopListData(){
		return getSqlSession().selectList("ShopListData");
	}
	public SeoulShopVO ShopDetailData(int no) {
		return getSqlSession().selectOne("ShopDetailData",no);
	}
}
