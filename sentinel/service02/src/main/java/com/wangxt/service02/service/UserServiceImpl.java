package com.wangxt.service02.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

@Service
@DubboService(version = "1.0.0", interfaceClass = UserService.class)
public class UserServiceImpl implements UserService {

    @Override
    @SentinelResource(fallback = "fallback")
    public String getUserInfo(String param) {
        // 超时响应
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "请求成功，参数为：" + param;
    }

    public String fallback(String param){
        return "服务降级了";
    }
}
