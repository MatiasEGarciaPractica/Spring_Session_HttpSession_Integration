package com.session.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enter")
public class EnterController {

    @GetMapping(value = "/hello")
    public String hello(){
        return "hello, using redis";
    }

}
