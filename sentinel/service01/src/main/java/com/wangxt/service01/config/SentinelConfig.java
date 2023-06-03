package com.wangxt.service01.config;

import com.alibaba.csp.sentinel.adapter.servlet.CommonFilter;
import com.alibaba.csp.sentinel.adapter.servlet.callback.WebCallbackManager;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.http.HttpServletResponse;

public class SentinelConfig {
    @Bean
    public FilterRegistrationBean sentinelFilterRegistration() {
        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new CommonFilter());
        registration.addUrlPatterns("/*");
        registration.setName("sentinelFilter");
        registration.setOrder(1);
        registration.addInitParameter("HTTP_METHOD_SPECIFY", "true");

        try {
            WebCallbackManager.setUrlBlockHandler((request, response, ex) -> {
                //response.sendRedirect("xxx.com");

                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                response.getWriter().println("query too many, please wait...");
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return registration;
    }
}
