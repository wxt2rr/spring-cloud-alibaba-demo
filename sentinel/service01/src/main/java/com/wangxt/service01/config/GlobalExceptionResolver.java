package com.wangxt.service01.config;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class GlobalExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("code", -40404);
        bodyMap.put("msg", "SORRY! System Error!");
        bodyMap.put("data", String.format("%s : %s", ex.getClass().getName(), System.currentTimeMillis()));
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("body", bodyMap);
        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put("code", 1);
        resultMap.put("header", headerMap);
        return mv.addAllObjects(resultMap);
    }

}