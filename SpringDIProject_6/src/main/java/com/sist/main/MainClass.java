package com.sist.main;

import java.util.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
import com.sist.vo.*;
public class MainClass {
	public static void main(String[] args) {
		
	}
	//location
	public void locationMain() {
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		LocationDAO dao=(LocationDAO)app.getBean("ldao");
		List<SeoulLocationVO> list=dao.LocationListData();
		for(SeoulLocationVO vo:list) {
			System.out.println(vo.getNo()+"."+vo.getTitle());
		}
	}
	
	public void locationDetail() {
		Scanner scan=new Scanner(System.in);
		System.out.print("번호입력: ");
		int no=scan.nextInt();
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		LocationDAO dao=(LocationDAO)app.getBean("ldao");
		SeoulLocationVO vo=dao.locationDetailData(no);
		System.out.println("title:"+vo.getTitle());
		System.out.println("Address:"+vo.getAddress());
		System.out.println("msg:"+vo.getMsg());
	}
	//nature
	
	public void NatureMain() {
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		NatureDAO dao=(NatureDAO)app.getBean("ndao");
		List<SeoulNatureVO> list=dao.NatureListData();
		for(SeoulNatureVO vo:list) {
			System.out.println(vo.getNo()+"."+vo.getTitle());
		}
	}
	
	public void natureDetail() {
		Scanner scan=new Scanner(System.in);
		System.out.print("번호입력: ");
		int no=scan.nextInt();
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		NatureDAO dao=(NatureDAO)app.getBean("ndao");
		SeoulNatureVO vo=dao.NatureDetailData(no);
		System.out.println("title:"+vo.getTitle());
		System.out.println("Address:"+vo.getAddress());
		System.out.println("msg:"+vo.getMsg());
	}
	//shop
	
	public void shopMain() {
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		ShopDAO dao=(ShopDAO)app.getBean("sdao");
		List<SeoulShopVO> list=dao.ShopListData();
		for(SeoulShopVO vo:list) {
			System.out.println(vo.getNo()+"."+vo.getTitle());
		}
	}
	@Test
	public void shopDetail() {
		Scanner scan=new Scanner(System.in);
		System.out.print("번호입력 : ");
		int no=scan.nextInt();
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		ShopDAO dao=(ShopDAO)app.getBean("sdao");
		SeoulShopVO vo=dao.ShopDetailData(no);
		System.out.println("title:"+vo.getTitle());
		System.out.println("Address:"+vo.getAddress());
		System.out.println("msg:"+vo.getMsg());
	}
	
}