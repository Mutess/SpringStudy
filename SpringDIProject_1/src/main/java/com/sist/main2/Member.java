package com.sist.main2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter // setter DI
@Getter
@AllArgsConstructor  // 5개를 다 포함하는 생성자

public class Member {
	private String id;
	private String name;
	private String address;
	private String phone;
	private String sex;
	
	public void print() {
		System.out.println("ID:"+id);
		System.out.println("Name:"+name);
		System.out.println("Address:"+address);
		System.out.println("Phone:"+phone);
		System.out.println("Sex:"+sex);
	}
}
