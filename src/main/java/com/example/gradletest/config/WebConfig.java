package com.example.gradletest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // カスタムルーティングの例（現在は不要）
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // ルートパスをindex.htmlにマッピング
        registry.addViewController("/").setViewName("forward:/index.html");
        
        // 他のパスもマッピング可能
        // registry.addViewController("/dashboard").setViewName("forward:/dashboard.html");
    }
}
