package com.example.bai3.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// Lớp này thay thế hoàn toàn cho file web.xml cũ kĩ
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { AppConfig.class }; // Gọi file cấu hình ở bước 2.1
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" }; // Bắt mọi đường dẫn (bao gồm cả /login)
    }
}