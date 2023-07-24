package com.sist.main4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
/*
	ApplicationContext
	AnnotationConfigApplicationContext ==> Sprint5
 */
public class MainClass {
	private Sawon sa;
	
	public Sawon getSa() {
		return sa;
	}

	public void setSa(Sawon sa) {
		this.sa = sa;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ApplicationContext app=new ClassPathXmlApplicationContext("app4.xml"); //close라는 명령어가 없음
		GenericApplicationContext app=new GenericXmlApplicationContext("app4.xml"); //close라는 명령어가 있음
/*		Sawon sa=(Sawon)app.getBean("sa1");
		// sa.print전에 init이 먼저 호출됨
		sa.print();
		// sa.destroy()는 호출 안됨..
		app.close(); */
		// 여기서 sa.destroy()이 호출이 됨
	}

}
