package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
	자바
		= 데이터형 / 변수 / 연산자 / 제어문 / 배열(1차)
		= 객체지향 프로그램 (클래스/객체) 객체지향 3대 요소(캡슐화,상속,포함, (오버로딩, 오버라이딩(다형성)))
			*** 캡슐화 VS  은닉화에 차이점
			*** 상속 VS 포함 차이점
			*** 오버라이딩 VS 오버로딩 차이점
		= 추상클래스/인터페이스
			*** 추상클래스 VS 인터페이스차이점
			*** 인터페이스의 장점
		= 예외처리
			*** 예외처리 목적 (사전에 오류잡기, 프로그램이 커지지 않게 하는것)
		= 라이브러리 (java.lang,java.util)
			= Collection,제네릭스
			  -----------------
			= IO
	오라클
		= DQL(SELECT) => JOIN/SubQuery
			*** JOIN의 종류
			*** SubQuery의 종류
		= DML(INSERT,UPDATE,DELETE)
		= DDL(CREATE,ALTER,DROP,TRUNCATE) => 제약조건
			*** 제약조건
		= TCL(COMMIT,ROLLBACK)
		= PL/SQL (프로시저)
			*** 프로시저와 트리거의 차이점
		= JDBC (DBCP/ORM(MyBatis,JPA))
			*** DAO VS Service 차이점
	HTML5/CSS (약간의 수정)
		*** GET VS POST 차이점
	JavaScript (기본) => 변수(let,const),제어문/연산자
					 => 함수
					 => 이벤트
					 => 태그 제어 (DOM)
					 => 라이브러리 (Jquery,VueJS,React)
			*** var(사용범위가 명확하지않음)지역변수 / let 지역변수 / const 상수 차이점
			*** 클로저
			*** prototype
			*** VueJS VS React 차이점
	JSP : 지시자(page,taglib),내장객체(request,response,session,application)
		  액션태그 (<jsp:include>)
		  TagLib (<c:~~>), EL(${})
		  MVC
		  *** MVC구조 (동작) 설명
	Spring : DI, AOP, MVC
		*** DI 설명
		*** AOP 설명
	--------------------------------------------------------------------
			 Option(websocket,task,security,spring-boot)
	AWS : 호스팅
 */
@Controller
public class GoodsController {
	@GetMapping("goods/list.do")
	public String goods_list() {
		return "goods/list";
	}
	@GetMapping("goods/detail.do")
	public String goods_detail(int no, Model model) {
		model.addAttribute("no", no);
		return "goods/detail";
	}
}
