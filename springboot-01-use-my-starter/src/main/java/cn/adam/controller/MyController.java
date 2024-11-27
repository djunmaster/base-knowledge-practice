package cn.adam.controller;

import cn.adam.service.MyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MyController {
    @Resource
    private MyService myService;

    @GetMapping("/hello")
    public String hello() {
        return myService.getMessage();
    }
}
