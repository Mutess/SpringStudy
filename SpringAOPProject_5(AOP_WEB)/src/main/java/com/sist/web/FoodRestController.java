package com.sist.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

/*
	어노테이션 => 메모리 할당
	@Component,
	@Repository, 
	@Service, 
	@Controller, 
	@RestController, 
	@ControllerAdvice, 
	@Configuration
 */
// 다른 언어 연결 => VueJS
// FoodVO => {} List<FoodVO> => [{},{},{},{},{},{}....] => JSON으로 변경 후 전송
@RestController
@CrossOrigin("http://localhost:3000") //VueJS, React는 포트 3000번대를 사용하기에 포트가 접근하는 것을 허용
public class FoodRestController {

}
