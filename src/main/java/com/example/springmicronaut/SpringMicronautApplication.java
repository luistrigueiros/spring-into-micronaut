package com.example.springmicronaut;

import io.micronaut.spring.boot.starter.EnableMicronaut;
import io.micronaut.spring.context.MicronautApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@EnableMicronaut
public class SpringMicronautApplication {

	public static void main(String[] args) {
        var context = new MicronautApplicationContext();
		context.start();
		new SpringApplicationBuilder().parent(context)
				.sources(SpringMicronautApplication.class)
				.build()
				.run();
	}

}
