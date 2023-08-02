package com.sist.service;

import java.util.*;

import com.sist.vo.*;

public interface FoodService {
	public List<CategoryVO> foodCategoryData();
	public List<FoodVO> foodTop7();
	public List<SeoulVO> seoulTop7();
}
