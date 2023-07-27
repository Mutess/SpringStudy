package com.sist.vo;

import java.util.*;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmpVO {
	private int empno,sal,deptno,comm;
	private String ename,job,dbday;
	private Date hiredate;
	// 조인 걸때 사용 (포함 클래스)
	private DeptVO dvo=new DeptVO();
}
