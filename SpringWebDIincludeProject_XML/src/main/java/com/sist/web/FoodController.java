package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.*;
import com.sist.vo.*;
@Controller
public class FoodController {
	@Autowired
	private FoodDAO dao;
	// food/food_list.do?cno=${vo.cno}
	@GetMapping("food/food_list.do") 
	public String food_list(int cno, Model model) {
		CategoryVO vo=dao.foodCategoryInfoData(cno);
		List<FoodVO> list=dao.foodListData(cno);
		
		model.addAttribute("cvo", vo);
		model.addAttribute("list", list); //request전송 객체
		model.addAttribute("main_jsp","../food/food_list.jsp");
		return "main/main";
	}
	//food_before_detail.do
	@GetMapping("food/food_before_detail.do")
	public String food_before_detail(int fno,RedirectAttributes ra,HttpServletResponse response/*쿠키 사용시 response사용*/) {
		/*
			Model : forward일때 값을 전송
			RedirectAttribute : sendRedirect일때 값을 전송
			addFlashAttribute : ?뒤에 들어가는 값을 숨겨서 보낼수 있음
		 */
		Cookie cookie=new Cookie("food_"+fno, String.valueOf(fno)); //형변환
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24);
		// cookie는 저장이 String로만 가능하다
		//브라우저로 전송
		response.addCookie(cookie);
		ra.addAttribute("fno", fno); // sendRedirect에서 보낼때 사용
		return "redirect:../food/food_detail.do";
	}
	@GetMapping("food/food_detail.do")
	public String food_detail(int fno,Model model) {
		//상세보기를 읽어옴
		//전소
		FoodVO vo=dao.foodDetailData(fno);
		model.addAttribute("vo", vo);
		model.addAttribute("main_jsp","../food/food_detail.jsp");
		return "main/main";
	}
}
