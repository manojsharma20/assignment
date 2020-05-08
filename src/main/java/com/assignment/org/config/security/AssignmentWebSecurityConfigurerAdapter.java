package com.assignment.org.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AssignmentWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AssignmentBasicAuthenticationEntryPoint authenticationEntryPoint;
	
	 @Autowired 
	 private UserDetailsService userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthenticationProvider());
	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider(){
	    DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
	    daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
	    daoAuthenticationProvider.setUserDetailsService(userDetailsService);
	    return daoAuthenticationProvider;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.sessionManagement()
		    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		 
		http.authorizeRequests()
		.antMatchers("/non-secure").permitAll()
		.anyRequest().authenticated().and()
		.httpBasic().authenticationEntryPoint(authenticationEntryPoint);
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}