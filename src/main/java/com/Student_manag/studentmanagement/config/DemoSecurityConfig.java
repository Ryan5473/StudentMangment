package com.burak.studentmanagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.burak.studentmanagement.service.StudentService;
import com.burak.studentmanagement.service.TeacherService;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private StudentService studentService;

	@Autowired
	private TeacherService teacherService;

	@Autowired
	private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// student and teacher login credentials are stored in mysql db,
		// while admin username and password defined below as in-memory
		auth
				.userDetailsService(studentService)
				.passwordEncoder(passwordEncoder());

		auth
				.userDetailsService(teacherService)
				.passwordEncoder(passwordEncoder());

		auth.inMemoryAuthentication() // admin password username
				.withUser("admin")
				.password(passwordEncoder().encode("1"))
				.roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.anyRequest().permitAll() // Allow all requests without restrictions
				.and()
				.formLogin()
				.loginPage("/showLoginPage") // Custom login page is generated in LoginController
				.loginProcessingUrl("/authenticateTheUser") // authenticateTheUser is automatically done by spring boot
				.successHandler(customAuthenticationSuccessHandler) // after login, user is redirected to home page depending on the role
				.permitAll()
				.and()
				.logout().permitAll(); // Allow all users to log out
	}

	// Needed for admin password encoding for security purposes
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}