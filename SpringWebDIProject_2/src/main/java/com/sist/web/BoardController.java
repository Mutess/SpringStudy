package com.sist.web;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
import com.sist.dao.*;
import com.sist.vo.BoardVO;

//메모리 할당
@Controller
@RequestMapping("board/")
public class BoardController {
	@Autowired
	private BoardDAO dao;
	// list.do?curpage=
	
	// 목록
	@GetMapping("list.do")
	public String board_list(String page, Model model) { //무조건 넘어오는 값이 INT면 바로 int로 받아도 되지만 page같은 경우 처음에 아무 값도 안보내주기때문에 String로만 받아야함
		// Model model => 전송객체 (request대신 사용) //필요한 변수는 무조건 매개변수로 받아야함
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		Map map=new HashedMap();
		int rowSize=10;
		int start=(curpage-1)*rowSize+1;
		int end=rowSize*curpage;
		map.put("start", start);
		map.put("end", end);
		List<BoardVO> list=dao.boardListData(map);
		int totalpage=dao.boardTotalPage();
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("list",list);
		return "board/list";
	}
	// 데이터 추가
	@GetMapping("insert.do")
	public String board_insert() {
		return "board/insert";
	}
	@PostMapping("insert_ok.do") //for
	public String board_insert_ok(BoardVO vo) {
		dao.boardInsert(vo);
		return "redirect:list.do";
	}
	// 데이터 수정
	@GetMapping("update.do")
	public String board_update(int no,Model model) { //model객체는 전송객채 (request대신 사용)
		BoardVO vo=dao.boardUpdateData(no);
		model.addAttribute("vo",vo);
		return "board/update";
	}
	// 데이터 삭제
	// 상세보기
	/*
		class Model{
			HttpServletRequest request;
			public void addAttribute(String key,object obj){
				request.setAttribute(key,obj);
			}
		}
	 */
	@GetMapping("detail.do")
	public String board_detail(int no, Model model) { //넘어올 값 설정 
		//String no=request.getParameter("no")
		BoardVO vo=dao.BoardDetailData(no);
		model.addAttribute("vo",vo);
		return "board/detail";
	}
	//delete.do?no=${vo.no } 400 : Bad Request
	@GetMapping("delete.do")
	public String board_delete(int no,Model model) {
		model.addAttribute("no", no);
		return "board/delete";
	}
	@PostMapping("delete_ok.do")
//	@ResponseBody 문자열로 줄수가 있음
	public String board_delect_ok(int no,String pwd,Model model) {
		boolean bCheck=dao.boardDelete(no, pwd);
		model.addAttribute("bCheck", bCheck);
		return "board/delete_ok";
	}
	/*
		1. Spring MVC
			1) DispatcherServlet 등록 => web.xml 가장 먼저 세팅
				=> 클래스를 등록한 파일 셋팅 (클래스 관리)
				=> 한글 변환 코드
			2) 클래스 제작 (순서)
				=> VO
				=> Mapper
				=> DAO
				=> Model
			3) application.xml (클래스 등록)
			4) JSP
		-------------------------------------------
	 */
	// 검색 ==> 동적쿼리
	// 
}
