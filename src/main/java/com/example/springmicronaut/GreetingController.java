package com.example.springmicronaut;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import jakarta.validation.constraints.Pattern;

import java.util.Map;

@Controller // <1>
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) { // <2>
        this.greetingService = greetingService;
    }

    @Get("/greeting") // <3>
    public Greeting greeting(
            @QueryValue(value="name", defaultValue="World") @Pattern(regexp = "\\D+") String name) {  // <4>
        return greetingService.greeting(name);
    }

    @Post("/greeting") // <5>
    public Greeting greetingByPost(@Body Greeting greeting) { // <6>
        return greetingService.greeting(greeting.getContent());
    }

    @Delete("/greeting") // <7>
    public HttpResponse<?> deleteGreeting() { // <8>
        Map<CharSequence, CharSequence> headers = Map.of("Foo", "Bar");
        return HttpResponse.noContent().headers(headers);
    }

    @Get("/greeting-status") // <3>
    public HttpResponse<Greeting> greetingWithStatus(
            @QueryValue(value="name", defaultValue="World") @Pattern(regexp = "\\D+") String name) {
        Greeting greeting = greetingService.greeting(name);
        return HttpResponse.created(greeting);
    }
}