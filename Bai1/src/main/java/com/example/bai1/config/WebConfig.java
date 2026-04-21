package com.example.bai1.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

    @Configuration
    @EnableWebMvc
// ĐÃ SỬA: Quét package cha "com.demo" để bao phủ cả .controller và .service
    @ComponentScan(basePackages = "com.example.bai1")
    public class WebConfig {

        @Bean
        public InternalResourceViewResolver viewResolver() {
            InternalResourceViewResolver resolver = new InternalResourceViewResolver();
            // Cấu hình đường dẫn đến thư mục chứa file jsp
            resolver.setPrefix("/WEB-INF/views/");
            resolver.setSuffix(".jsp");
            return resolver;
        }
    }

