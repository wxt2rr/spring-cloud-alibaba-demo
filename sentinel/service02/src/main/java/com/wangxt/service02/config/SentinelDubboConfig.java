package com.wangxt.service02.config;

import com.alibaba.csp.sentinel.adapter.dubbo.config.DubboAdapterGlobalConfig;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.dubbo.rpc.AsyncRpcResult;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * dubbo提供者的全局降级、处理
 */
@Component
public class SentinelDubboConfig {
    {
        DubboAdapterGlobalConfig.setProviderFallback((invoker, invocation, e) -> {
            if (e instanceof FlowException) {
                System.out.println("service 2 服务被限流了");
            } else if (e instanceof DegradeException) {
                System.out.println("service 2 服务被降级了");
            }


            String obj = "service 异常响应";
            return AsyncRpcResult.newDefaultAsyncResult(obj, invocation);
        });
    }
}
