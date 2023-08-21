package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FoodVO {
	private int fno,cno;
	private String name,phone,type,parking,price,time,menu,poster,address;
	private double score;
	private String sessionId,userName,rdata;
}
