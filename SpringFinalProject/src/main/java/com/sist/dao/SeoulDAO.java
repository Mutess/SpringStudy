package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.SeoulMapper;
import com.sist.vo.SeoulVO;

@Repository
public class SeoulDAO {
	@Autowired
	private SeoulMapper mapper;
	
	public List<SeoulVO> seoulListData(Map map){
		return mapper.seoulListData(map);
	}
	
	/* @Select("SELECT CEIL(COUNT(*)/20.0) FROM #{table_name}"); */
	public int seoulTotalpage(Map map) {
		return mapper.seoulTotalpage(map);
	}
}
