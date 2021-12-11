package com.virtualeduc.tuescuelavirtual;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class TuescuelavirtualApplication implements CommandLineRunner{

	@Autowired
	private BCryptPasswordEncoder passWordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(TuescuelavirtualApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		String clave="12345";
		
		for(int i=0;i<2;i++) {
			String bcryptedPassword=passWordEncoder.encode(clave);
			System.out.println(bcryptedPassword);
		}
	}
	
	

}
