package com.example.api_gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();

        // Chỉ định origin cụ thể thay vì "*"
        config.setAllowedOrigins(List.of("*"));

        // Cho phép các phương thức HTTP
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // Cho phép các headers cụ thể hoặc tất cả headers
        config.setAllowedHeaders(List.of("*"));

        // Quan trọng: Phải bật credentials nếu client gửi cookie hoặc authentication
        // token
        config.setAllowCredentials(true);

        // Đăng ký CORS config vào các đường dẫn API
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}
