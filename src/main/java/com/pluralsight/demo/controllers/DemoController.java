package com.pluralsight.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping
    public String helloClass(){
        return "Hi thereee, this is Tesfahun";
    }
}
