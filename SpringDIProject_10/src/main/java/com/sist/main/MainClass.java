package com.sist.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.dao.Board;
import com.sist.dao.FreeBoardDAO;

@Component("mc")
public class MainClass {
	
	@Autowired //자동주입 => 스프링에서 자동으로 객체 주소값을 찾아서 주입 
	@Qualifier("ddao") //단 객체가 2개 이상일때 @Qualifier("객체명") 해당 객체를 지정하여 사용
	private Board board;
	
	@Autowired
	private FreeBoardDAO f;  //객체마다 @Autowired를 해줘야 자동 주입이 됨
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		 
	}

}
