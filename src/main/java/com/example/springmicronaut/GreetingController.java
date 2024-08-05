package com.example.springmicronaut;

import jakarta.validation.constraints.Pattern;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController // <1>
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) { // <2>
        this.greetingService = greetingService;
    }

    @GetMapping("/greeting") // <3>
    public Greeting greeting(
            @RequestParam(value="name", defaultValue="World") @Pattern(regexp = "\\D+") String name) {  // <4>
        return greetingService.greeting(name);
    }

    @PostMapping("/greeting") // <5>
    public Greeting greetingByPost(@RequestBody Greeting greeting) { // <6>
        return greetingService.greeting(greeting.getContent());
    }

    @DeleteMapping("/greeting") // <7>
    public ResponseEntity<?> deleteGreeting() { // <8>
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Foo", "Bar");
        return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT); // <8>
    }

    @GetMapping("/greeting-status") // <3>
    @ResponseStatus(code = HttpStatus.CREATED) // <9>
    public Greeting greetingWithStatus(
            @RequestParam(value="name", defaultValue="World") @Pattern(regexp = "\\D+") String name) {
        return greetingService.greeting(name);
    }
}