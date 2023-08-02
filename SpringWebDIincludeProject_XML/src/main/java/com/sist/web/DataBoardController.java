package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URLEncoder;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

import com.sist.vo.*;
import com.sist.dao.*;
@Controller
public class DataBoardController {
	@Autowired
	private DataBoardDAO dao;
	
	// 목록 출력
	@GetMapping("databoard/list.do")
	public String databoard_list(String page,Model model) {
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=10;
		int start=(curpage-1)*rowSize+1;
		int end=curpage*rowSize;
		
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		
		List<DataBoardVO> list=dao.databoardListData(map);
		int totalpage=dao.databoardTotalPage();
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("main_jsp", "../databoard/list.jsp");
		return "main/main";
	}
	// 데이터 추가
	@GetMapping("databoard/insert.do")
	public String databoard_insert(Model model) {
		model.addAttribute("main_jsp", "../databoard/insert.jsp");
		return "main/main";
	}
	@PostMapping("databoard/insert_ok.do")
	public String databoard_insert_ok(DataBoardVO vo) {
		List<MultipartFile> list=vo.getFiles();
		if(list==null) { //업로드가 안된 상태
			vo.setFilename("");
			vo.setFilesize("");
			vo.setFilecount(0);
		}else { // 업로드가 된 상태
			String filenames="";
			String filesizes="";
			for(MultipartFile mf:list) {
				File file=new File("c:\\download\\"+mf.getOriginalFilename());
				try {
					mf.transferTo(file); //파일 업로드
				} catch (Exception e) {}
				filenames+=file.getName()+",";
				long len=file.length();
				filesizes+=len+",";
			}
			filenames=filenames.substring(0,filenames.lastIndexOf(","));
			filesizes=filesizes.substring(0,filesizes.lastIndexOf(","));
			vo.setFilename(filenames);
			vo.setFilesize(filesizes);
			vo.setFilecount(list.size());
		}
		dao.databoardInsert(vo);
		return "redirect:../databoard/list.do";
	}
	// 요청 데이터가 없는 경우 : String으로 설정
	// 모든 데이터는 String으로 받을 수 있다
	// 매개변수는 순서가 없다 , 여러개를 받을 수 있다
	/*
		MVC의 핵심 => 매개변수 / 리턴형
							----- 화면이동 (forward / sendRedirect)
								  forward => 화면 변경 => request
								  	return "main/main";
								  sendRedirect => 화면 변경 => request를 초기화
								  			   => 기존의 설정된 위치로 변경
		1) Model(Controller) => 매개변수 설정
			매개변수 : 사용자가 보내준 값을 받는다 (1. 일반 데이터(int, String...)
										 2. 데이터를 모아서 처리
										 	=> ~VO (커멘드 객체)
										 3. checkbox => String[])
					내장 객체
					-------
					HttpServletRequest, HttpServletResponse
					---------------------------------------
						=> 다운로드, Cookie 사용
					HttpSession, Model, RedirectAttributes,
					passwordEncoder
		DAO : 데이터베이스 연동
		Controller : 조립기 (DAO연동 => 데이터를 추출 => 브라우저 전송)
		VO : 관련된 데이터를 모아서 관리 (사용자 정의 데이터형)
		Manager : Open API
		RestController : JavaScript로 JSON을 전송할 목적
		-------------- 다른 언어와 연결 => 데이터를 전송
					  --------
					  1. WEB => JavaScript (Ajax, VueJS, React)
					  2. Mobile => Kotlin
		service : BI => DAO여러개 통합, 다른 서비스 통합 (크롤링) => 의존성이 낮은 프로그램
	 */
	@GetMapping("databoard/detail.do")
	public String databoard_detail(int no,Model model) {
		DataBoardVO vo=dao.databoardDetailData(no);
		if(vo.getFilecount()>0) {
			String filenames=vo.getFilename();
			StringTokenizer st=new StringTokenizer(filenames,",");
			List<String> nList=new ArrayList<String>();
			while(st.hasMoreTokens()) {
				nList.add(st.nextToken());
			}
			String filesizes=vo.getFilesize();
			st=new StringTokenizer(filesizes,",");
			List<String> sList=new ArrayList<String>();
			while(st.hasMoreTokens()) {
				sList.add(st.nextToken());
			}
			model.addAttribute("nList", nList);
			model.addAttribute("sList", sList);
		}
		model.addAttribute("vo", vo);
		model.addAttribute("main_jsp", "../databoard/detail.jsp");
		return "main/main";
	}
	//../databoard/download.do?fn=${fn }
	

	//다운로드 코딩
	@GetMapping("databoard/download.do")
	public void databoardDownload(String fn,HttpServletResponse response) {
		try {
			File file=new File("c:\\download\\"+fn); //파일 정보 읽기
			response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(fn, "UTF-8"));
			// Download
			BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
			// 서버에서 파일을 읽기
			BufferedOutputStream bos=new BufferedOutputStream(response.getOutputStream());//클라이언트 영역
			// 사용자에게 전송
			int i=0; // 읽은 byte 수
			byte[] buffer=new byte[1024]; // TCP(1024) / UDP(512)
			while((i=bis.read(buffer,0,1024))!=-1) { // -1 : EOF
				bos.write(buffer,0,i);
			}
			bis.close();
			bos.close();
		}catch (Exception e) {}
	}
	@PostMapping("databoard/find.do")
	public String databoard_find(String fs,String ss, Model model) {
		// DAO에 연결
		Map map=new HashMap();
		map.put("fs", fs);
		map.put("ss", ss);
		List<DataBoardVO> list=dao.databoardFindData(map);
		model.addAttribute("list",list);
		model.addAttribute("count", list.size());
		model.addAttribute("main_jsp", "../databoard/find.jsp");
		return "main/main";
	}
	//databoard/update.do?no=${vo.no }
	@GetMapping("databoard/update.do")
	public String databoard_update(int no,Model model) {
		//DAO연동
		DataBoardVO vo=dao.databoarUpdateData(no);
		model.addAttribute("vo", vo);
		model.addAttribute("main_jsp", "../databoard/update.jsp");
		return "main/main";
	}
	
	@PostMapping("databoard/update_ok.do")
	@ResponseBody //승격 (@RestController)
	public String databoard_update_ok(DataBoardVO vo) {
		String result="";
		// DAO 연동
		boolean bCheck=dao.databoardUpdate(vo);
		if(bCheck==true) {
			result="<script>"
				 + "location.href=\"../databoard/detail.do?no="+vo.getNo()+"\";"
				 	+ "</script>";
		}else {
			result="<script>"
				 + "alert(\"비밀번호가 틀립니다!!\");"
				 + "history.back();"
				 + "</script>";
		}
		return result;
	}
	// 삭제하는 창으로 이동
	@GetMapping("databoard/delete.do")
	public String databoard_delete(int no,Model model) {
		model.addAttribute("no", no);
		model.addAttribute("main_jsp", "../databoard/delete.jsp");
		return "main/main";
	}
	// 실제 삭제 => @ResponBody => @RestController
	@PostMapping("databoard/delete_ok.do")
	@ResponseBody
	public String databoard_delete_ok(int no,String pwd) {
		String result="";
		// DAO 연동
		boolean bCheck=dao.databoardDelete(no, pwd);
		if(bCheck==true) {
			result="<script>"
				 + "location.href=\"../databoard/list.do\""
				 	+ "</script>";
		}else {
			result="<script>"
				 + "alert(\"비밀번호가 틀립니다!!\");"
				 + "history.back();"
				 + "</script>";
		}
		return result;
	}
}
