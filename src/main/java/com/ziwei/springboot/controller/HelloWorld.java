package com.ziwei.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;


@Controller
public class HelloWorld {
   /* @RequestMapping({"/","/index.html"})
    public String index(){
        return "index";
    }*/
    @ResponseBody//将hello写出去
    @RequestMapping("/hello")
    public String helloWorld()
        {
        return "hello world ";
    }

    //查出用户数据，在页面显示
    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","你好");
        map.put("users",Arrays.asList("zhangsan","lisi","wangwu"));
        return "success";
    }

}
