package com.sist.vo;

import java.util.*;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmpVO {
	private int empno,sal,deptno,comm;
	private String ename,job,dbday,dbsal;
	private Date hiredate;
}
