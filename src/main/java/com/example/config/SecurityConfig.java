package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserService user;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(user).passwordEncoder(passwordEncoder);
		
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http//.csrf().disable()
		.authorizeRequests()
		.antMatchers("/css/**", "/js/**", "/images/**").permitAll()
		.antMatchers("/login","/reg","/register").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.loginProcessingUrl("/authenticate")
		.defaultSuccessUrl("/home")
		.failureUrl("/login?error=true")
		.permitAll()
		.and()
		.logout()
		.logoutUrl("/logout")
		.logoutSuccessUrl("/login?logout=true")
		.invalidateHttpSession(true)
		.deleteCookies("JSESSIONID")
		.permitAll()
		.and().csrf().ignoringAntMatchers("/login","/reg","/register","/authenticate");
	}
	

}
