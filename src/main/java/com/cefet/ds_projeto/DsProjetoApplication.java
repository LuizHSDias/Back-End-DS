package com.cefet.ds_projeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DsProjetoApplication {

	// DOCUMENTAÇÃO PROJETO 
	// http://localhost:8080/swagger-ui/index.html#/

	// BANCO DE DADOS 
	// https://ds-projeto.onrender.com/ 

	// APLICAÇÃO FRONT-END NETFLY 
	// https://ds-projeto.netlify.app/ 
	
	public static void main(String[] args) {
		SpringApplication.run(DsProjetoApplication.class, args);

		 BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	        String hash = encoder.encode("123456");
	        System.out.println(hash);
	}
}