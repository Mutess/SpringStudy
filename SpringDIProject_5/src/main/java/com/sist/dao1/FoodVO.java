package com.sist.dao1;

import lombok.Getter;
import lombok.Setter;

/*
	 CNO                                       NOT NULL NUMBER(2)
	 TITLE                                     NOT NULL VARCHAR2(100)
	 SUBTITLE                                  NOT NULL VARCHAR2(200)
	 POSTER                                    NOT NULL VARCHAR2(260)
	 LINK                                      NOT NULL VARCHAR2(100)
 */
@Getter
@Setter
public class FoodVO {
	private int cno;
	private String title,subtitle,poster,link;
}
