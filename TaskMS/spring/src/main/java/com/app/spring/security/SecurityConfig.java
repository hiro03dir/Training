package com.app.spring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // CORSの設定を有効化、POSTリクエストにCSRFトークンが必要
        http.cors(Customizer.withDefaults());
        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers( "/login").permitAll()
                .anyRequest().authenticated());
        // UsernamePasswordAuthenticationFilterの前にAuthorizeFilterを実行する設定
        http.addFilterBefore(new AuthorizeFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(LoginUserDetailsService loginUserDetailsService) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(loginUserDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    private CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration= new CorsConfiguration();
        corsConfiguration.addAllowedMethod(CorsConfiguration.ALL);
        corsConfiguration.addAllowedHeader(CorsConfiguration.ALL);
        // クロスドメインのリクエストに対してX-AUTH-TOKENヘッダーでトークンを返すように設定
        corsConfiguration.addExposedHeader("X-AUTH-TOKEN");
        // TODO: URLを変更
        corsConfiguration.addAllowedOrigin("http://front-origin.example.com");
        corsConfiguration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource corsSource = new UrlBasedCorsConfigurationSource();
        corsSource.registerCorsConfiguration("/**", corsConfiguration);
        return corsSource;
    }

}
