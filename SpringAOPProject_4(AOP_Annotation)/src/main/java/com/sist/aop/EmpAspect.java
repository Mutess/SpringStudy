package com.sist.aop;

/*
	Aspect : AOP는 OOP를 대체하는 프로그램이 아닌 
			 OOP를 보완한 프로그램
			 *** OOP => 콜백함수가 존재하지 않음
			 			----- 시스템에 의해 자동으로 호출되는 함수 (main, service)
			 	 => 한개, 두개의 공통으로 사용되는 내용을 메소드로 처리
			 	 	getConnection , disConnection
			 	 => 여러개가 공통으로 사용되는 내용 => 클래스
			 	 	CreateDataBase
			 	 	-------------- 공통모듈
	스프링에서는 반복적인 코딩을 모아서 관리 => 필요시에 의해 자동으로 호출
	----------------------------------------- AOP
	*** 사용자 정의는 많이 사용하지 않는다 : (라이브러리:트랜잭션,보안,로그파일)
	*
	AOP
	---
		어떤 메소드에 적용 : PointCut(메소드명을 지정)
		=> pointcut="execution(* com.sist.main.*      *      (..))"  *은 전체  //
							(리턴형            클래스명  메소드명    매개변수(X), 매개변수 (O))
							
		=> pointcut="within("com.sist.main.*")"
					 패키지 단위로 등록
		호출되는 위치 설정 : JoinPoint
			@Transactional => 이걸 사용시 아래 어노테이션이 호출하지 않아도 자동실행
			public String display(){
				@Before
				try{
					--------------------- @Around : setAutoCommit(false)
					==핵심 코딩
					--------------------- @Around : commit()
				}catch(Exception e){
					@After-Throwing : 오류처리 : rollback()
				}finally{
					@After : setAutoCommit(true), disConnection()
				}
				return ""; @After-Returning
			}
		JoinPoint+Pointcut => Advice => Aspect
		Weabing : 통합 => Proxy패턴 (대리자)
		
		public class A{
			public void display(){
			
			}
		}
		
		public class Proxy{
			private A a;
			public Proxy(A a){
				this.a=a;
			}
			public void display(){
				@Before => 설정된 메소드 호출
				a.display();
				@After => 설정된 메소드 호출
			}
		}
 */
import java.util.*;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sist.dao.*;
@Aspect
@Component
public class EmpAspect {
	@Autowired
	private EmpDAO dao;
	
	@Before("execution(* com.sist.dao.EmpDAO.emp*(..))") //emp라고 시작하는 메소드를 호출할때
	// try시작과 동시에 호출
	public void getConnection() {
		System.out.println("오라클 연결");
		dao.getConnection();
	}
	@After("execution(* com.sist.dao.EmpDAO.emp*(..))")
	// finally에서 호출
	public void disConnection() {
		System.out.println("오라클 해제");
		dao.disConnection();
	}
	@AfterReturning(value = "execution(* com.sist.dao.EmpDAO.emp*(..))",returning = "obj") //정상수행 => return값을 받아서 처리
	public void print(Object obj) { // returning = "obj"랑 print(Object obj) 변수명이 일치해야함
		List<EmpVO> list=(List<EmpVO>)obj;
		for(EmpVO vo:list) {
			System.out.println(vo.getEmpno()+" "
					+vo.getEmpno()+" "
					+vo.getJob()+" "
					+vo.getDbday()+" "
					+vo.getSal());
		}
	}
	@AfterThrowing(value = "execution(* com.sist.dao.EmpDAO.emp*(..))",throwing = "e") //catch를 수행했을때 처리
	public void exception(Throwable e) {
		System.out.println("에러발생");
		e.printStackTrace();
	}
}
