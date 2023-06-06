package com.wangxt.service02.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

@Service
@DubboService(version = "1.0.0", interfaceClass = PayService.class)
public class PayServiceImpl implements PayService {

    @Override
    //@SentinelResource(fallback = "fallback")
    public String pay(String param) {
        if(param.equals("1")){
            // 异常响应
            String str = null;
            str.length();
        }

        return "请求成功，参数为：" + param;
    }

    public String fallback(String param){
        return "服务降级了,参数为:" + param;
    }
}
