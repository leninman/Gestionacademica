package com.virtualeduc.tuescuelavirtual;







import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("error_403").setViewName("error_403");
	}
	
	
	@Bean
	public BCryptPasswordEncoder passwordencoder() {
		
		return new BCryptPasswordEncoder();
		
	}
}
