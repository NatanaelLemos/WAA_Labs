//package edu.mum.waa.exercise8_5;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//	@Autowired
//	public void yourAuthenticationConfig(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//		.withUser("sales").password("123").roles("SALES")
//		.and()
//		.withUser("admin").password("123").roles("ADMIN")
//		.and()
//		.withUser("books").password("123").roles("ACCOUNT");
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//		.antMatchers("/login", "/login-error").permitAll() 
//		.antMatchers("/cars").hasRole("SALES")
//		.antMatchers("/bookStore").hasRole("ACCOUNT") 
//		.and() 
//		.formLogin().loginPage("/login").failureUrl("/login-error").successForwardUrl("/").permitAll(); 
//	}
//}
//
