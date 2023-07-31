package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.mapper.*;
import com.sist.vo.*;
import java.util.*;
@Repository
public class SeoulDAO {
	@Autowired
	private SeoulMapper mapper;
	//명소
	/*
		@Select("SELECT no,title,poster,num "
				+ "FROM (SELECT no,title,poster,rownum as num "
				+ "FROM (SELECT no,title,poster "
				+ "FROM seoul_location ORDER BY no ASC)) "
				+ "WHERE num BETWEEN #{start} AND #{end}") */
		public List<SeoulVO> seoulLocationListData(Map map){
			return mapper.seoulLocationListData(map);
		}
//		@Select("SELECT CEIL(COUNT(*)/12.0) FROM seoul_location")
		public int seoulLocationTotalPage() {
			return mapper.seoulLocationTotalPage();
		}
		// 자연
//		@Select("SELECT no,title,poster,num "
//				+ "FROM (SELECT no,title,poster,rownum as num "
//				+ "FROM (SELECT no,title,poster "
//				+ "FROM seoul_nature ORDER BY no ASC)) "
//				+ "WHERE num BETWEEN #{start} AND #{end)")
		public List<SeoulVO> seoulNatureListData(Map map){
			return mapper.seoulNatureListData(map);
		}
//		@Select("SELECT CEIL(COUNT(*)/12.0) FROM seoul_nature")
		public int seoulNatureTotalpage() {
			return mapper.seoulLocationTotalPage();
		}
		//쇼핑
//		@Select("SELECT no,title,poster,num "
//				+ "FROM (SELECT no,title,poster,rownum as num "
//				+ "FROM (SELECT no,title,poster "
//				+ "FROM seoul_shop ORDER BY no ASC)) "
//				+ "WHERE num BETWEEN #{start} AND #{end}")
		public List<SeoulVO> seoulShopListData(Map map){
			return mapper.seoulShopListData(map);
		}
//		@Select("SELECT CEIL(COUNT(*)/12.0) FROM seoul_shop")
		public int seoulShopTotalpage() {
			return mapper.seoulShopTotalpage();
		}
	
}
