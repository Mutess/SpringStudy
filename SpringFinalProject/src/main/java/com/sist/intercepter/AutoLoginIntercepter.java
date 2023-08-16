package com.sist.intercepter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sist.vo.MemberVO;
/*
	main.do ====================DispatcherServlet =========> HandlerMapping
													  |		 @Getmapping("main/main.do")
												preHandle		|
																|	return ""
																|	------> postHandle
															 ViewResolver
															 	|  model
															 	|  ----> afterCompletion
															 	|
															   JSP
 */											
//<bean>태그 이용
public class AutoLoginIntercepter extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		Cookie[] cookies=request.getCookies();
		if(cookies != null) {
			for(int i=0; i<cookies.length; i++) {
				String key=cookies[i].getName();
				if(key.equals("id")) {
					String id = cookies[i].getValue();
					request.setAttribute("id", id);
					break;
				}
			}
		}
		return super.preHandle(request, response, handler);
	}

}
