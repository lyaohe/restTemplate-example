package com.example.rest.demo1.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liangyaohe on 2019/4/14.
 */
@RestController
@RequestMapping("/demo")
public class demoController {

    @GetMapping("/get")
    public String get(){
        return "hello world";
    }

    @PostMapping("/post")
    public Map<String, Object> post(String name){
        Map<String, Object> res = new HashMap<>();
        res.put("id", 1);
        res.put("method", "post");
        res.put("name", name);
        return res;
    }

}
