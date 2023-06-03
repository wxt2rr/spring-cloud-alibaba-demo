package com.wangxt.service01.controller;

import com.wangxt.service02.service.RpcService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class DemoController {

    @DubboReference(version = "1.0.0", timeout = 10000)
    private RpcService rpcService;

    @RequestMapping("A")
    public String methodA() {
        return "methodA";
    }

    @RequestMapping("B")
    public String methodB() {
        return "methodB";
    }


    @RequestMapping("rpcA")
    public String rpcMethodA() {
        return rpcService.dubboService("rpc methodA");
    }

    @RequestMapping("rpcB")
    public String rpcMethodB() {
        return rpcService.dubboService("rpc methodB");
    }
}
