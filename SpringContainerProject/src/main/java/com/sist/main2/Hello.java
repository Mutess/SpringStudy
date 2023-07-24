package com.sist.main2;
/*
	인터페이스는 클래스와 클래스를 연결해주는 역할
	스프링은 인터페이스 기반
	
	독립적(인터페이스도 없는)
	1 2
	3 4 가 다른 클래스
	POJO 방식(Plain Old Java Object)
	
	메인 클래스가 에러가 나면 안됨
 */
public interface Hello {
	public String sayHello(String name);
}
