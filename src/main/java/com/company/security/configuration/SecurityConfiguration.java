package com.company.security.configuration;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled=true)
public class SecurityConfiguration {

    private final UserDetailsService appUserDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // For GraphQL
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/admin/**", "/api/admin/**").hasRole("ADMIN")
                        .requestMatchers("/sales/**", "/api/sales/**").hasRole("SALES")
                        //.requestMatchers(permitPaths()).permitAll()
                        .anyRequest().permitAll()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .rememberMe((rememberMe) -> rememberMe.userDetailsService(appUserDetailsService))
        ;
        return http.build();
    }

    private String[] permitPaths() {
        return new String[] {
                "/graphql**",
                "/graphiql**",
                "/swagger-ui.html",
                "/test/**",
                "/css/**",
                "/js/**",
                "/metrics/**",
                "/health/**",
                "/webjars/**",
                "/favicon.ico",
                "/product/**",
                "/login",
                "/resources/**"
        };
    }

    @Bean
    public PasswordEncoder encoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    public static void main(String[] args) {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        System.out.println(encoder.encode("admin"));
    }
}
