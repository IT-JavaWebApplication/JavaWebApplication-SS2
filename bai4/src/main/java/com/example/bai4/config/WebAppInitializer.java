package com.example.bai4.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // Nạp file cấu hình AppConfig vừa tạo ở bước 1
        return new Class[]{AppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        // Ánh xạ mọi request (/) qua DispatcherServlet của Spring xử lý
        return new String[]{"/"};
    }
}