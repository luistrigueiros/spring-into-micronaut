package com.example.springmicronaut;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@MicronautTest(startApplication = false) // <1>
class GreetingServiceTest {

    @Inject
    GreetingService greetingService;

    @Test
    void regexValidationNonDigitsWork() {
        assertDoesNotThrow(() -> greetingService.greeting("foo"));
        assertThrows(ConstraintViolationException.class, () -> greetingService.greeting("12foo"));
    }
}