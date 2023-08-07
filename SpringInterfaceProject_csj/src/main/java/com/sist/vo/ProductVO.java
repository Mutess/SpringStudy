package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductVO {
	private int pdno,goods_count;
	private String title,poster,subject,sale,priced_sale,original_pri,first_pri,delivery_pri;
	double score;
}
