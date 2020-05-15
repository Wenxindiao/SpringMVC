package com.kuang.controller;

import com.kuang.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {

    @RequestMapping("/t1")
    public String test1(){
        return "hello";
    }

    @RequestMapping("/a1")
    public void a1(String name, HttpServletResponse response) throws IOException {
        System.out.println("a1: name = " + name);
        if ("kuangshen".equals(name)){
            response.getWriter().println("true");
        } else {
            response.getWriter().println("false");
        }
    }

    @RequestMapping("/a2")
    public List<User> a2(){
        List<User> users = new ArrayList<User>();

        //添加数据
        users.add(new User("文涛", 1, "男"));
        users.add(new User("涛", 2, "男"));
        users.add(new User("迪", 3, "女"));
        return users;
    }

    @RequestMapping("/a3")
    public String a3(String name, String pwd){
        String msg = "";
        if (name!=null){
            //判断用户名是否为admin
            if ("admin".equals(name)) {
                msg = "ok";
            } else {
                msg = "用户名有误";
            }
        }
        if (pwd != null) {

            //判断密码是否为123456
            if ("123456".equals(pwd)) {

                msg = "ok";
            } else {
                msg = "密码有误";
            }
        }
        return msg;
    }
}
