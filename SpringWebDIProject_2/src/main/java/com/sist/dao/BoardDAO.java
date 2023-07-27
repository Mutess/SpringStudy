package com.sist.dao;

import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;

//메모리 할당
@Repository
public class BoardDAO {
	@Autowired
	private BoardMapper mapper;
	
///*	@Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD'),hit,num "
//			+ "FROM (SELECT no,subject,name,regdate,hit,rownum as num "
//			+ "FROM (SELECT /*+ INDEX_DESC(springBoard sb_no_pk)*/no,subject,name,regdate,hit "
//			+ "FROM springBoard)) "
//			+ "WHERE num BETWEEN #{start} AND #{end}")
//	// 							map.get("start") map.get("end") 
	public List<BoardVO> boardListData(Map map) {
				return mapper.boardListData(map);
			}
	
//	@Select("SELECT CEIL(COUNT(*)/10.0) FROM springBoard")
	public int boardTotalPage() {
		return mapper.boardTotalPage();
	}
	
	@Insert("INSERT INTO springBoard(no,name,subject,content,pwd) "
			+ "VALUES(sb_no_seq.nextval,#{name},#{subject},#{content},#{pwd})")
										//vo.getName()
	public void boardInsert(BoardVO vo) {
		mapper.boardInsert(vo);
	}
	
/*	@Select("SELECT * FROM springBoard "
			+ "WHERE no=#{no}")*/
	public BoardVO BoardDetailData(int no) {
		mapper.hitIncrement(no); //조회수 증가
		return mapper.BoardDetailData(no); //데이터 가져오기
	}
}
