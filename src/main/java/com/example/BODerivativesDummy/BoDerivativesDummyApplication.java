package com.example.BODerivativesDummy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.example.BODerivativesDummy.*")
public class BoDerivativesDummyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoDerivativesDummyApplication.class, args);
	}

}
