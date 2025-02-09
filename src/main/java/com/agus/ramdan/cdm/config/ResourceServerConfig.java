package com.agus.ramdan.cdm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Profile("oauth2")
public class ResourceServerConfig {

    // @formatter:off
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .mvcMatcher("/api/cdm/**")
                .authorizeRequests()
                .mvcMatchers("/api/cdm/**").access("hasAuthority('SCOPEcdm.write')")
                .and()
                .authorizeRequests()
                .mvcMatchers("/api/cdm/**").access("hasAuthority('SCOPEcdm.read')")
                .and()
                .oauth2ResourceServer()
                .jwt();
        return http.build();
    }
    // @formatter:on

}