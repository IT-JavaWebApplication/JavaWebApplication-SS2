package com.example.bai2.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class}; // Nạp cấu hình từ file WebConfig ở trên
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"}; // Bắt mọi đường dẫn URL để đưa cho Spring xử lý
    }
}