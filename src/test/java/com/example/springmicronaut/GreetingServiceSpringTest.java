package com.example.springmicronaut;

import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = {GreetingService.class, GreetingConfiguration.class})
class GreetingServiceSpringTest extends GreetingServiceTest {
}