package com.example.Ingredient_Management.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // すべてのエンドポイントにCORSを適用
                .allowedOrigins("http://localhost:3000") // フロントエンドのURLを指定
                .allowedMethods("GET", "POST", "PUT", "DELETE") // 許可するHTTPメソッド
                .allowedHeaders("Content-Type", "Authorization") // 許可するヘッダー
                .allowCredentials(true); // クレデンシャル（Cookieなど）の送信を許可
    }
}