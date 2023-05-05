package com.SpringTest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private UserDetailsService UserDetailSevice;
	
//	@Autowired
//	UserDetailsService UserDetailSevice;
	
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception{
        http.formLogin(login -> login
                .loginProcessingUrl("/login")
                .loginPage("/loginpage")
                .successForwardUrl("/success")
                .failureForwardUrl("/fail"));
		
		http.authorizeHttpRequests()
			.requestMatchers("/loginpage").permitAll()
			.requestMatchers("/success").permitAll()
			.requestMatchers("/fail").permitAll()
			.anyRequest().authenticated();
		
		return http.build();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
