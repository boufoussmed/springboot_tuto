package com.boufouss.springboot.tutorial.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.random.RandomGenerator;

@RestController
public class Controller {

    @Value("${welcome.message}")
    private String msgStr;

    //@RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String hello(){
        return msgStr;
    }

    @GetMapping("/loc")
    public String cart(){
        return RandomGenerator.SplittableGenerator.of("L128X1024MixRandom").toString();
    }
}
