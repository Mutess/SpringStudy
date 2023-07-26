package com.sist.dao;
/*
	 CNO                                       NOT NULL NUMBER(2)
	 TITLE                                     NOT NULL VARCHAR2(100)
	 SUBTITLE                                  NOT NULL VARCHAR2(200)
	 POSTER                                    NOT NULL VARCHAR2(260)
 */

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryVO {
	private int cno;
	private String title,subtitle;
}
