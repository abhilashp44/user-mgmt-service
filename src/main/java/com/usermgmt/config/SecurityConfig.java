package com.usermgmt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeRequests(authorize -> {
            authorize.antMatchers("/**/actuator/**", "/**/swagger-ui/**",
                                  "/**/swagger-resources/**",
                                  "/**/api-docs/**").permitAll();
            authorize.anyRequest().authenticated();
        }).oauth2ResourceServer(oauth2ResourceServer -> oauth2ResourceServer.jwt());
        return http.build();
    }
}
