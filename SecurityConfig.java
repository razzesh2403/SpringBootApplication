package com.mvc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
//Instead of theese four annotation even we can extend WebSecurityConfigurerAdapter
//@EnableGlobalMethodSecurity		//login pop is shown
@EnableGlobalAuthentication 	//login pop is shown
@EnableWebSecurity			//login page is displayed
//@EnableWebMvcSecurity			//login page is displayed but depricated

public class SecurityConfig extends WebSecurityConfigurerAdapter{
		@Autowired
		DataSource dataSource;
		/*public void configGlobal(AuthenticationManagerBuilder auth) throws Exception{
			auth.inMemoryAuthentication().withUser("test").password("test").roles("USER")
			.and().withUser("admin").password("pass").roles("USER","ADMIN");
			
		}*/
		@Autowired
		public void configAuthentication(AuthenticationManagerBuilder auth)throws Exception{
			auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery("select username,password,enabled from users where username=?")
			.authoritiesByUsernameQuery("select username,role from user_roles where username=?");
		}

	public void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("/")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.permitAll()
		.and()
		.rememberMe()
		.tokenRepository(persistentTokenRepository())
		.tokenValiditySeconds(30)
		.and()
		.logout()
		.permitAll();
	}
	
	@Autowired
	public PersistentTokenRepository persistentTokenRepository(){
		
		JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
		db.setDataSource(dataSource);
		return db;
	}
}
