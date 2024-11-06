package com.example.demo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.profile.DevProfile;
import com.example.demo.profile.ProductionProfile;
import com.example.demo.profile.SystemProfile;

@Configuration
public class JavaConfig {
    @Bean
    @ConditionalOnProperty(value="demo.dev", havingValue="true", matchIfMissing=true)
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(value = "demo.dev", havingValue="false")
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}
