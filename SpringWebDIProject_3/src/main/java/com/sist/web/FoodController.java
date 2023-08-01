package com.sist.web;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.*;
import com.sist.vo.*;
//가지고 온 값을 보내줌
@Controller
public class FoodController {
	@Autowired
	private FoodDAO dao;
	
	@RequestMapping("food/category.do")
	// 4.3 GET / POST / => (GET,POST)
	//int같이 값이 넘어가는 경우 처음 실행하자마자 값이 null값이기 때문에 String으로 값을 받고 형변환후 값을 넘겨줌
	public String food_category(String cno,Model model) {
		if(cno==null)
			cno="1";
		Map map=new HashMap();
		map.put("cno", Integer.parseInt(cno)); // 여기에 "cno"가 food-mapper에 cno 키값임
		List<CategoryVO> list = dao.categoryListData(map);
		
		model.addAttribute("list", list);
		return "food/category";
	}
}
