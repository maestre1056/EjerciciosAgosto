package com.example.ej6.pathvariableheaders;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template="Hello, %s!";
    private final AtomicLong counter=new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name",defaultValue = "World")String name){
        return new Greeting(counter.incrementAndGet(),
                String.format(template,name));
    }


    @PostMapping("/person")
    public Greeting1 getPerson(@RequestBody Greeting1 greeting1){
        return greeting1;
    }

    @GetMapping("/person/{id}/{contenido}")
    public Greeting1 person(@PathVariable int id, @PathVariable String contenido){
        return new Greeting1(id, contenido);
    }
    @PutMapping("/person/put")
    public Greeting1 put(@RequestParam int id, @RequestParam String contenido){
        return new Greeting1(id, contenido);
    }
}
