package com.wangxt.service02.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class DemoController {


    @RequestMapping("pay")
    @ResponseBody
    public String pay() {
        return "支付完成";
    }

    @RequestMapping("userinfo")
    @ResponseBody
    public String userinfo() {
        return "用户为：" + DemoController.class.getName();
    }
}
