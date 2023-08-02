package com.sist.aop;

/*
	언제 어디서 호출할지 여부 확인
	1. 시점 : pointcut => 메소드
	2. 호출위치 : joinpoint
		@Before : try시작전에 호출
		@After : finally에서 호출
		@Around : 위 아래 => 로그파일 (시작, 끝 시간까지 체크), 트랜젝션 처리
		@After-Throwing : catch(오류발생)
		@After-Returning : 정상수행
		---------------------------
		@Transactional
		public void display(){
			try{
				Before (핵심코드를 시작하기 전)
				-------------------------- @Around => conn.setAutoCommit(false)
				--- 핵심 코딩 (INSERT)
				-------------------- conn.commit()
			}catch(exception e){
				@After-Throwing  => conn.rollback()
			}finally{
				@After => conn.setAutoConnit(true)
			}
			return "";  @After-Returning
		}
	-------------------- advice를 모아두면 advicer
	
	---------------------- aspect
 */
public class BoardAspect {
	public void before() { //문장을 수행하기 호출
		System.out.println("오라클 연결!");
	}
	public void after() { //문장 수행이 종료 => finally
		System.out.println("오라클 해제!");
	}
}
