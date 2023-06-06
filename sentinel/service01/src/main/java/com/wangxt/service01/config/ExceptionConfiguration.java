package com.wangxt.service01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExceptionConfiguration {
    @Bean
    public GlobalExceptionResolver globalExceptionResolver() {
        return new GlobalExceptionResolver();
    }

}