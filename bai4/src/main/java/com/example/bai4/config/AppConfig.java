package com.example.bai4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.example.bai4") // Quét toàn bộ package để tìm Controller
public class AppConfig {

    // Cấu hình ViewResolver để Spring biết đường dẫn tới file JSP
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/"); // Thư mục chứa các file giao diện
        resolver.setSuffix(".jsp");            // Đuôi file
        return resolver;
    }
}