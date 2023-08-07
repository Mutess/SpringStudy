package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.ProductVO;

public interface ProductMapper {
	@Select("SELECT pdno,title,poster,PRICED_SALE,num "
			+ "FROM (SELECT pdno,title,poster,PRICED_SALE,rownum as num "
			+ "FROM (SELECT pdno,title,poster,PRICED_SALE "
			+ "FROM product_detail ORDER BY pdno ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<ProductVO> productListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM product_detail")
	public int productTotalpage();
	
	@Select("SELECT pdno,title,poster,PRICED_SALE,num "
			+ "FROM (SELECT pdno,title,poster,PRICED_SALE,rownum as num "
			+ "FROM (SELECT pdno,title,poster,PRICED_SALE "
			+ "FROM product_detail ORDER BY ASC WHERE title LIKE '%'||#{title}||'%')) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<ProductVO> productFindData(Map map);
	
}
