package com.demo.elk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EsController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello ELK";
    }
}
