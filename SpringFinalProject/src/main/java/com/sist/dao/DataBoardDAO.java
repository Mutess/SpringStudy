package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.DataBoardMapper;
import com.sist.vo.DataboardVO;

@Repository
public class DataBoardDAO {
	@Autowired
	private DataBoardMapper mapper;
	
/*	@Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num "
			+ "FROM (SELECT no,subject,name,regdate,hit,rownum as num "
			+ "FROM (SELECT no,subject,name,regdate,hit "
			+ "FROM springDataBoard ORDER BY no DESC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")*/
	public List<DataboardVO> databoardListData(Map map){
		return mapper.databoardListData(map);
	}
	
	public int databoardTotalPage() {
		return mapper.databoardTotalPage();
	}
	
/*	@Insert("INSERT INTO springDataBoard VALUES("
			+ "sdb_no_seq.nextval,#{name},#{subject},#{content},"
			+ "#{pwd},SYSDATE,0,#{filename},#{filesize},#{filecount})") */
	public void databoardInsert(DataboardVO vo) {
		mapper.databoardInsert(vo);
	}
/*	@Update("UPDATE springDataboard SET "
			+ "hit=hit+1 "
			+ "WHERE no=#{no}")
	public void hitIncrement(int no);
	
	@Select("SELECT no,name,subject,content,TO_CHAR(regdate,'YYYY-MM-DD') as dbday, filename,filesize,filecount "
			+ "FROM springDataBoard "
			+ "WHERE no=#{no}")*/
	public DataboardVO dataBoardDetailData(int no) {
		mapper.hitIncrement(no);
		return mapper.dataBoardDetailData(no);
	}
	public DataboardVO databoardUpdateData(int no) {
		return mapper.dataBoardDetailData(no);
	}
	
/*	@Select("SELECT pwd FROM springDataBoard "
			+ "WHERE no=#{no}")
	public String databoardGetPassword(int no);
	
	@Update("UPDATE springDataBoard SET "
			+ "name=#{name}, subject=#{subject},content=#{content} "
			+ "WHERE no=#{no}")*/
	public String databoardUpdate(DataboardVO vo) {
		String result="";
		String db_pwd=mapper.databoardGetPassword(vo.getNo());
		if(db_pwd.equals(vo.getPwd())) {
			result="yes";
			mapper.databoardUpdate(vo);
		}else {
			result="no";
		}
		return result;
	}
	
//	@Delete("DELETE FROM springDataBoard WHERE no=#{no}")
	public String databoardDelete(int no,String pwd) {
		String result="";
		String db_pwd=mapper.databoardGetPassword(no);
		if(db_pwd.equals(pwd)) {
			result="yes";
			mapper.databoardDelete(no);
		}else {
			result="no";
		}
		return result;
	}
	
/*	@Select("SELECT filname,filecount FROM springDataboard "
			+ "WHERE no=#{no}")*/
	public DataboardVO databoardFileInfoData(int no) {
		return mapper.databoardFileInfoData(no);
	}
	
}
