package com.sist.main2;

public class HelloImp1 implements Hello {
	
	@Override
	public String sayHello(String name) {
		return name+"님 환영합니다";
	}
}
