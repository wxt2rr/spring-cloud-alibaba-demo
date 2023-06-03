package com.wangxt.service02.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class DemoController {


    @RequestMapping("A")
    @ResponseBody
    public String methodA() {
        return "methodA";
    }

    @RequestMapping("B")
    @ResponseBody
    public String methodB() {
        return "methodB";
    }
}
