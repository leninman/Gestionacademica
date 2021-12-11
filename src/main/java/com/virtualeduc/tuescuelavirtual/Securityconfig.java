package com.virtualeduc.tuescuelavirtual;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.virtualeduc.tuescuelavirtual.auth.handler.LoginSuccessHandler;
import com.virtualeduc.tuescuelavirtual.services.JpaUserDetailsService;


@EnableGlobalMethodSecurity(securedEnabled=true, prePostEnabled=true)
@Configuration
public class Securityconfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private LoginSuccessHandler successHandler;
	
	
	/*
	@Autowired
	private DataSource ds;
	*/
	
	
	@Autowired
	private BCryptPasswordEncoder passwordencoder;
	
	
	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	
	
	
	
	
	

	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception{
		
		
		builder.userDetailsService(userDetailsService)
		.passwordEncoder(passwordencoder);
		
		/*
		builder
		.jdbcAuthentication()
		.dataSource(ds)
		.passwordEncoder(passwordencoder)
		.usersByUsernameQuery("select USUARIO,CLAVE,HABILITADO,ACTIVO from usuarios where USUARIO=? and HABILITADO=1 and ACTIVO=1")
		.authoritiesByUsernameQuery("select b.USUARIO,a.NOMBRE_ROL from roles a INNER JOIN usuarios b ON (a.ID_USUARIO=b.ID_USUARIO) where b.USUARIO=?");*/
		
		
		
		/*
		PasswordEncoder encoder=passwordencoder();
		
		UserBuilder users=User.builder().passwordEncoder(password->{
			return encoder.encode(password);
		});
		
		builder.inMemoryAuthentication()
		.withUser(users.username("admin").password("12345").roles("ADMIN","USER"))
		.withUser(users.username("lenin").password("12345").roles("USER"))
		.withUser(users.username("sinai").password("sinai2021").roles("USER"));
		*/
		
		
	}
	
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.authorizeRequests().antMatchers("/","/css/**",
		"/js/**","/images/**","/app/inicio").permitAll()
		/*.antMatchers("/app/listaralumnos").hasAnyRole("USER")
		.antMatchers("/app/registroalumno").hasAnyRole("ADMIN")
		.antMatchers("/app/verAlumno/**").hasAnyRole("USER")
		.antMatchers("/app/cargarcurso/**").hasAnyRole("ADMIN")*/
		.anyRequest().authenticated()
		.and()
				.formLogin()
					.successHandler(successHandler)
					.loginPage("/login")
				.permitAll()
		.and()
				.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/error_403");;
		
	}

}
