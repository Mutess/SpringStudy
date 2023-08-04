package com.sist.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/*
	searchMainDailyBoxOffice.do
	
 */
@RestController //데이터만 보내는 역할
public class MovieRestController {
	private String[] urls= {"","https://www.kobis.or.kr/kobis/business/main/searchMainDailyBoxOffice.do",
			"https://www.kobis.or.kr/kobis/business/main/searchMainRealTicket.do",
			"https://www.kobis.or.kr/kobis/business/main/searchMainDailySeatTicket.do"};
	
	@GetMapping(value = "movie/movie_rank_vue.do", produces = "text/plain;charset=UTF-8")
	/*
		1. HTML => text/html
 		2. XML => text/xml
		3. JSON => text/plain
		
		VO ===> {} ===> JSONObject
		List ===> [{},{},{}...] =====> JSONArray 자바스크립트에서
		
		Rest => React / Redux / Vue / AngularJS
	 */
	public String movie_rank(int no) {
		return "";
	}
}
