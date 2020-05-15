package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RestController  //不会被视图解析器解析，返回的是json字符串
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model){

        //封装数据
        model.addAttribute("msg", "Hello, SpringMVC-Annotation");

        return "hello"; //会被视图解析器处理
    }


}
