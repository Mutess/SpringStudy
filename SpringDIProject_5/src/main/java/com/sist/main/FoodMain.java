package com.sist.main;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao1.*;
public class FoodMain {
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("app2.xml");
		FoodDAO dao=(FoodDAO)app.getBean("dao");
		List<FoodVO> list=dao.foodListData();
		for(FoodVO vo:list) {
			System.out.println(vo.getCno()+"."+vo.getTitle());
		}
		
	}
}
