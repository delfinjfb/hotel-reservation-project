package com.your_project_name.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")  // ✅ Allow access to all /api/ endpoints
                        .allowedOrigins("http://localhost:4200")  // ✅ Allow frontend
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // ✅ Allow HTTP methods
                        .allowedHeaders("*")  // ✅ Allow all headers
                        .allowCredentials(true);
            }
        };
    }
}
