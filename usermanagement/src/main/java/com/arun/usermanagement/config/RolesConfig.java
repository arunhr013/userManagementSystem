package com.arun.usermanagement.config;

import com.arun.usermanagement.util.ApplicationConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class RolesConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req -> req
                        .requestMatchers(ApplicationConstants.API_VERSION_V1+ApplicationConstants.GET_ALL_USER).hasAnyRole(ApplicationConstants.ADMIN_USER,ApplicationConstants.ROLE_USER)
                        .requestMatchers(ApplicationConstants.API_VERSION_V1+ApplicationConstants.DELETE_USER).hasRole(ApplicationConstants.ADMIN_USER)
                        .requestMatchers(ApplicationConstants.API_VERSION_V1+ApplicationConstants.GET_USER).hasAnyRole(ApplicationConstants.ADMIN_USER,ApplicationConstants.ROLE_USER)
                        .requestMatchers(ApplicationConstants.API_VERSION_V1+ApplicationConstants.CREATE_USER).hasRole(ApplicationConstants.ADMIN_USER_USERNAME)
                        .requestMatchers(ApplicationConstants.API_VERSION_V1+ApplicationConstants.EDIT_USER).hasAnyRole(ApplicationConstants.ADMIN_USER,ApplicationConstants.ROLE_USER)
                        .anyRequest().authenticated()
                );

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username(ApplicationConstants.ROLE_USER_USERNAME)
                .password(passwordEncoder().encode(ApplicationConstants.ROLE_USER_PASSWORD))
                .roles(ApplicationConstants.ROLE_USER)
                .build();
        UserDetails admin = User.builder()
                .username(ApplicationConstants.ADMIN_USER_USERNAME)
                .password(passwordEncoder().encode(ApplicationConstants.ADMIN_USER_PASSWORD))
                .roles(ApplicationConstants.ADMIN_USER)
                .build();
        return new InMemoryUserDetailsManager(user,admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}


