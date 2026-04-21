package com.example.bai2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.example.bai2") // Thay bằng tên package ngoài cùng của bạn để Spring quét tìm Controller
public class WebConfig implements WebMvcConfigurer {

    // Hàm này chỉ cho Spring biết các file .jsp được giấu ở đâu
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/"); // Đảm bảo bạn đã tạo thư mục WEB-INF/views trong src/main/webapp
        resolver.setSuffix(".jsp");
        return resolver;
    }
}