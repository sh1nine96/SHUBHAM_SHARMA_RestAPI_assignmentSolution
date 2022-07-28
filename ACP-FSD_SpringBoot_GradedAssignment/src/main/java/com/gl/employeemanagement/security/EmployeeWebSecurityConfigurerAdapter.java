package com.gl.employeemanagement.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gl.employeemanagement.serviceimpl.EmployeeUserDetailsService;

@Configuration
@EnableWebSecurity
public class EmployeeWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		AuthenticationProvider authenticationProvider = customAuthenticationProvider();
		auth.authenticationProvider(authenticationProvider);
	}

	@Bean
	public UserDetailsService customUserDetailsService() {
		return new EmployeeUserDetailsService();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider customAuthenticationProvider() {
		DaoAuthenticationProvider daoProvider = new DaoAuthenticationProvider();

		daoProvider.setUserDetailsService(customUserDetailsService());
		daoProvider.setPasswordEncoder(passwordEncoder());
		return daoProvider;
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2-console/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/createService/addNewEmployees", "/h2-console/**", "/user/addNewUser",
						"​/role/addNewRole")
				.hasAuthority("ADMIN")
				.antMatchers("/", "/login", "/readService/**", "/updateService/updateExistingEmployeeRecord",
						"/deleteService/deleteEmployeebyId")
				.hasAnyAuthority("USER", "ADMIN").anyRequest().authenticated().and().formLogin()
				.loginProcessingUrl("/login").successForwardUrl("/").permitAll().and().logout()
				.logoutSuccessUrl("/login").permitAll()

				.and().cors().and().csrf().disable();
	}

}
