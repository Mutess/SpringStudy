package com.sist.dao;

import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.ProductMapper;
import com.sist.vo.ProductVO;
@Repository
public class ProductDAO {
	@Autowired
	private ProductMapper mapper;
	
//	@Select("SELECT pdno,title,poster,PRICED_SALE,num "
//			+ "FROM (SELECT pdno,title,poster,PRICED_SALE,rownum as num "
//			+ "FROM (SELECT pdno,title,poster,PRICED_SALE "
//			+ "FROM product_detail ORDER BY ASC)) "
//			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<ProductVO> productListData(Map map){
		return mapper.productListData(map);
	}
	
//	@Select("SELECT CEIL(COUNT(*)/12.0) FROM product_detail")
	public int productTotalpage() {
		return mapper.productTotalpage();
	}
}
