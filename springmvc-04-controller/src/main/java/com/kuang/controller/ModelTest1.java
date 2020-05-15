package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModelTest1 {

    @GetMapping("/m1/t1")
    public String test1(Model model){

        model.addAttribute("msg", "ModelTest1");

        //重定向
        return "redirect:/index.jsp";

    }
}
