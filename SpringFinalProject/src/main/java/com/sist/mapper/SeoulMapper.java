package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.SeoulVO;
public interface SeoulMapper {
/*	<select id="seoulLocationData" resultType="SeoulVO" parameterType="hashmap">
		SELECT no,poster,name,title,num
		FROM (no,poster,name,title,rownum as num
		FROM (no,poster,name,title 
		FROM seoul_location ORDER BY no ASC))
		WHERE num BETWEEN #{start} AND #{end}
	</select>*/
	public List<SeoulVO> seoulListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/20.0) FROM ${table_name}")
	public int seoulTotalpage(Map map);
}
