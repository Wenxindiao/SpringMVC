package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerTest3 {

    @RequestMapping("/t3")
    public String test(Model model){

        model.addAttribute("msg", "haahaa");

        return "test";
    }
}
