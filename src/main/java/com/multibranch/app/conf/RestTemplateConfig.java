package com.multibranch.app.conf;

import java.time.Duration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Value("${restTemplate.timeout:60000}")
    private Integer TIMEOUT;

    public RestTemplateConfig() {
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.setConnectTimeout(Duration.ofMillis((long)this.TIMEOUT)).setReadTimeout(Duration.ofMillis((long)this.TIMEOUT)).build();
    }
}
