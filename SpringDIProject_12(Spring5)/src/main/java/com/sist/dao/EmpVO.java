package com.sist.dao;

import java.util.*;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmpVO {
	private int empno,sal,comm,deptno;
	private String ename,job,dbday;
	private Date hiredate;
}
