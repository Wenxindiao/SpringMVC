package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EncodingController {

    @GetMapping("e1/t1")
    public String test1(@RequestParam("name") String name){
        System.out.println("name: " + name);
        return "test";

    }

}
