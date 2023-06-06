package com.wangxt.service01.controller;

import com.wangxt.service01.bean.ServerResponse;
import com.wangxt.service02.service.PayService;
import com.wangxt.service02.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class DemoController {

    @DubboReference(version = "1.0.0", timeout = 10000)
    private UserService userService;

    @DubboReference(version = "1.0.0", timeout = 10000)
    private PayService payService;

    @RequestMapping("pay")
    @ResponseBody
    public String pay(@RequestParam("type") String type) {
        if(type.equals("1")){
            String str = null;
            str.length();
        }
        return "支付完成";
    }

    @RequestMapping("userinfo")
    @ResponseBody
    public String userinfo() {
        return "用户为：" + com.wangxt.service02.controller.DemoController.class.getName();
    }


    @RequestMapping("payRPC")
    @ResponseBody
    public String payRPC(@RequestParam("type") String type) {
        String pay = null;
        try{
            pay = payService.pay(type);
        }catch (Exception e){
            e.printStackTrace();
            pay = pay + ":" + e.getMessage();
        }
        return pay;

    }

    @RequestMapping("userinfoRPC")
    @ResponseBody
    public String userinfoRPC(@RequestParam("type") String type) {
        return userService.getUserInfo(type);
    }

    @RequestMapping("test")
    @ResponseBody
    public ServerResponse<String> test(@RequestParam("type") String type) {
        return ServerResponse.createBySuccess();
    }
}
