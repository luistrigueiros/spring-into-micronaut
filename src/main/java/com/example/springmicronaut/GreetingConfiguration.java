package com.example.springmicronaut;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.core.bind.annotation.Bindable;
import jakarta.validation.constraints.NotBlank;

@ConfigurationProperties("greeting") // <2>
public interface GreetingConfiguration {
    @Bindable(defaultValue = "Hello, %s!")
    @NotBlank
    String getTemplate();
}