/*package com.mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.mvc.dao.impl.UserDaoImpl;
import com.mvc.service.impl.UserServiceImpl;



@Configuration
@ComponentScan("com.mvc")
@EnableAspectJAutoProxy
public class AppConfig {
	
	@Bean
	public UserDaoImpl userDao(){
		
		return new UserDaoImpl();
	}
	
	@Bean
	public UserServiceImpl userService(){
		
		return new UserServiceImpl();
	}
	
	@Bean
	public DriverManagerDataSource dataSourece(){
		
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/test");
		datasource.setPassword("admin");
		datasource.setUsername("root");
			
		return datasource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(){
		
		return new JdbcTemplate(dataSourece());
	}
	
	
	
	@Bean 
	public CacheingAdvice cacheingAdvice(){
		return new CacheingAdvice();
	}
	
	@Bean 
	public ProfilingAdvice profilingAdvice(){
		return new ProfilingAdvice();
	}


}
*/