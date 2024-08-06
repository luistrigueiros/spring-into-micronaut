package com.example.springmicronaut;

import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringJUnitConfig(classes = {GreetingService.class, GreetingConfiguration.class})
class GreetingServiceTest {

    @Inject
    GreetingService greetingService;

    @Test
    void regexValidationNonDigitsWork() {
        assertDoesNotThrow(() -> greetingService.greeting("foo"));
        assertThrows(ConstraintViolationException.class, () -> greetingService.greeting("12foo"));
    }
}