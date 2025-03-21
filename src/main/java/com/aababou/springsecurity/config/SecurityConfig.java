package com.aababou.springsecurity.config;

/*
author otman
    */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception  {

       http.csrf(customizer->customizer.disable());
        http.authorizeHttpRequests(authorizeRequests ->authorizeRequests.anyRequest().authenticated());
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        http.sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();

    }
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =  User.
                withDefaultPasswordEncoder().
                username("otmane").
                password("ot@12").
                roles("USER","ADMIN")
                .build();

        UserDetails user1 =  User.
                withDefaultPasswordEncoder().
                username("aababou").
                password("ab@12").
                roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user,user1);
    }
}
