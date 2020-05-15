package com.kuang.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuang.pojo.User;
import com.kuang.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController //类里面的所有请求返回的均是json字符串
public class UserController {

    @RequestMapping("/j1")
    //@ResponseBody  //它就不会走视图解析器，会直接返回一个字符串
    public String json1() throws JsonProcessingException {

        //jackson
        ObjectMapper mapper = new ObjectMapper();

        //创建一个对象
        User user = new User("文涛", 23, "男");

        String str = mapper.writeValueAsString(user);

        return str;
    }

    @RequestMapping("/j2")
    public String json2() throws JsonProcessingException {

        //jackson
        ObjectMapper mapper = new ObjectMapper();

        List<User> users = new ArrayList<User>();

        //创建一个对象
        User user1 = new User("文涛", 23, "男");
        User user2 = new User("文涛", 23, "男");
        User user3 = new User("文涛", 23, "男");
        User user4 = new User("文涛", 23, "男");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        String str = mapper.writeValueAsString(users);

        return str;
    }

    @RequestMapping("/j3")
    public String json3() throws JsonProcessingException {

        Date date = new Date();

        return JsonUtils.getJson(date);
    }

    @RequestMapping("/j4")
    public String json4() throws JsonProcessingException {

        List<User> users = new ArrayList<User>();

        //创建一个对象
        User user1 = new User("文涛", 23, "男");
        User user2 = new User("文涛", 23, "男");
        User user3 = new User("文涛", 23, "男");
        User user4 = new User("文涛", 23, "男");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        String str = JSON.toJSONString(users);

        System.out.println("*******Java对象 转 JSON字符串*******");
        String str1 = JSON.toJSONString(str);
        System.out.println("JSON.toJSONString(list)==>"+str1);
        String str2 = JSON.toJSONString(user1);
        System.out.println("JSON.toJSONString(user1)==>"+str2);

        System.out.println("\n****** JSON字符串 转 Java对象*******");
        User jp_user1=JSON.parseObject(str2,User.class);
        System.out.println("JSON.parseObject(str2,User.class)==>"+jp_user1);

        System.out.println("\n****** Java对象 转 JSON对象 ******");
        JSONObject jsonObject1 = (JSONObject) JSON.toJSON(user2);
        System.out.println("(JSONObject) JSON.toJSON(user2)==>"+jsonObject1.getString("name"));

        System.out.println("\n****** JSON对象 转 Java对象 ******");
        User to_java_user = JSON.toJavaObject(jsonObject1, User.class);
        System.out.println("JSON.toJavaObject(jsonObject1, User.class)==>"+to_java_user);

        return str;
    }
}
