package com.sky.corvid.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CorvidController {

    // 'maps' this method to a GET request at /hello
    @GetMapping("/hello")
    public String test() {
        return "Hello, World!";
    }

}