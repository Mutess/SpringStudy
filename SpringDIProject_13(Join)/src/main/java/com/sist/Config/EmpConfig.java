package com.sist.Config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/*
	@Component
	@Repository
	@Service
	@Controller
	@RestController
	@ControllerAdvice, 
 	@Configuration
 */
@Configuration  //xml를 자바로 변경한 어노테이션
// <context:component-scan base-package="com.sist.*"/>
@ComponentScan(basePackages = "com.sist.*")
// <mybatis-spring:scan base-package="com.sist.mapper2"/>
@MapperScan(basePackages = "com.sist.mapper2")
public class EmpConfig {
	/*
		<bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
			p:driverClassName="oracle.jdbc.driver.OracleDriver"
			p:url="jdbc:oracle:thin:@localhost:1521:xe"
			p:username="hr"
			p:password="happy"
		/>
	 */
	@Bean("ds")
	public DataSource dataSource() {
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("hr");
		ds.setPassword("happy");
		return ds;
	}
	@Bean("ssf")
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean ssf=new SqlSessionFactoryBean();
		ssf.setDataSource(dataSource());
		return ssf.getObject();
	}
}
