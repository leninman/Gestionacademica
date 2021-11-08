package com.virtualeduc.tuescuelavirtual;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class Securityconfig extends WebSecurityConfigurerAdapter {
	
	
	
	@Bean
	public BCryptPasswordEncoder passwordencoder() {
		
		return new BCryptPasswordEncoder();
		
	}
	
	

	@Autowired
	public void ConfigurerGlobal(AuthenticationManagerBuilder builder) throws Exception{
		
		PasswordEncoder encoder=passwordencoder();
		
		UserBuilder users=User.builder().passwordEncoder(password->{
			return encoder.encode(password);
		});
		
		builder.inMemoryAuthentication()
		.withUser(users.username("admin").password("12345").roles("ADMIN","USER"))
		.withUser(users.username("lenin").password("12345").roles("USER"));
		
		
		
	}
	
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.authorizeRequests().antMatchers("/","/css/**",
		"/js/**","/images/**","/app/inicio").permitAll()
		.antMatchers("/app/listaralumnos").hasAnyRole("USER")
		.antMatchers("/app/registroalumno").hasAnyRole("ADMIN")
		.antMatchers("/app/verAlumno/**").hasAnyRole("USER")
		.antMatchers("/app/cargarcurso/**").hasAnyRole("ADMIN")
		.anyRequest().authenticated()
		.and()
				.formLogin().loginPage("/login")
				.permitAll()
		.and()
				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).clearAuthentication(true)
				.logoutSuccessUrl("/login?logout").deleteCookies("JSESSIONID")
				.invalidateHttpSession(true);
	}

}
