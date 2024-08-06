package com.example.springmicronaut;

import io.micronaut.runtime.Micronaut;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMicronautApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMicronautApplication.class, args);
		Micronaut.run(SpringMicronautApplication.class, args);
	}

}
