package com.westos.Information.config;

import com.westos.Information.config.handler.OfficeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootConfiguration
public class OfficeConfig implements WebMvcConfigurer {
    @Autowired
    private OfficeHandler handler;

    /**
     * 拦截器配置，可以添加多个拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(handler).addPathPatterns("/apps/dataIndex.html");
    }
}
