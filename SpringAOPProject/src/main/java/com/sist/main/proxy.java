package com.sist.main;

public class proxy {
	private Sawon sawon;
	public void Proxy(Sawon sawon) {
		this.sawon=sawon;
	}
	public void display() {
		System.out.println("before");
		sawon.display();
		System.out.println("after");
	}
}
