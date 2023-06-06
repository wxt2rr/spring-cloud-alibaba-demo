package com.wangxt.service01.config;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wangxt.service01.bean.ServerResponse;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * HTTP请求的sentinel的全局限流、降级异常处理器
 * sentinel的异常处理器先于全局异常执行
 */
@Component
public class MyBlockExceptionHandler implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        String msg = "服务正常响应";
        int code = 200;
        if (e instanceof FlowException) {
            msg = "当前请求过于频繁，请求已被限流";
            code = -40000;
        } else if (e instanceof DegradeException) {
            msg = "当前服务运行异常，服务已被降级";
            code = -40001;
        }

        httpServletResponse.setStatus(200);
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setHeader("Content-Type", "application/json:charset=utf-8");
        httpServletResponse.setContentType("application/json:charset=utf-8");
        new ObjectMapper().writeValue(httpServletResponse.getWriter(), ServerResponse.createBySuccess(msg));
    }

}
