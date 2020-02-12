package com.alcocerap.pps.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/")
public class PpsController {

    @GetMapping("hello")
    public String getHello() {
        return "hello";
    }

}