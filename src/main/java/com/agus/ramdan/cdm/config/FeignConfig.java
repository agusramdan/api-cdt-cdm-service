package com.agus.ramdan.cdm.config;
import com.agus.ramdan.cdm.exception.CustomFeignErrorDecoder;
import com.agus.ramdan.cdm.interceptor.AuthorizationRequestInterceptor;
import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.agus.ramdan.cdm.service")
public class FeignConfig {
    @Bean
    public RequestInterceptor requestInterceptor() {
        return new AuthorizationRequestInterceptor();
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomFeignErrorDecoder();
    }
}
