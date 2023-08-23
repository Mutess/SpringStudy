package com.sist.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@Aspect
@Component
public class FooterAspect {
	@Autowired
	private AspectDAO dao;
	
	@After("execution(* com.sist.web.*Controller.*(..))")
	public void footerData() {
		// => 매개변쉥 값을 채워준다 (DispatcherServlet)
		// => @Controller, @RestController
		HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		//PageContext
		List<FoodVO> fList=dao.foodTop7Data();
		List<String> sList=dao.seoulTop7Data();
		List<String> rList=dao.recipeTop7Data();
		
		request.setAttribute("fList", fList);
		request.setAttribute("sList", sList);
		request.setAttribute("rList", rList);
	}
}
