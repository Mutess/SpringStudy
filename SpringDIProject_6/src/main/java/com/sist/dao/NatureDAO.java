package com.sist.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
public class NatureDAO extends SqlSessionDaoSupport {
	/*
		<sql id="select-sql">
			SELECT no,title,address,msg
			FROM seoul_Nature
			</sql>
			<select id="NatureListData" resultType="SeoulNatureVO">
				SELECT no,title,address,msg,rownum
				FROM (SELECT no,title,address,msg FROM seoul_nature ORDER BY no ASC)
				WHERE rownum &lt;=10
			</select>
			<select id="NatureDetailData" resultType="SeoulNatureVO" parameterType="int">
				<include refid="select-sql"/>
				WHERE no=#{no}
			</select>
	 */
	public List<SeoulNatureVO> NatureListData(){
		return getSqlSession().selectList("NatureListData");
	}
	public SeoulNatureVO NatureDetailData(int no) {
		return getSqlSession().selectOne("NatureDetailData",no);
	}
}
