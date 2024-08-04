package com.example.springmicronaut;

import io.micronaut.spring.boot.starter.EnableMicronaut;
import io.micronaut.spring.context.MicronautApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@EnableMicronaut
public class SpringmicronautApplication {

	public static void main(String[] args) {
		var builder = new SpringApplicationBuilder();
		var context = new MicronautApplicationContext();
		context.start();
		builder.parent(context)
				.sources(SpringmicronautApplication.class)
				.build()
				.run();
	}

}
