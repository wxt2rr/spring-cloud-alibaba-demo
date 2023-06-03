package com.wangxt.service02.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

@Service
@DubboService(version = "1.0.0", interfaceClass = RpcService.class)
public class RpcServiceImpl implements RpcService {

    @Override
    public String dubboService(String param) {
        return "请求成功，参数为：" + param;
    }
}
