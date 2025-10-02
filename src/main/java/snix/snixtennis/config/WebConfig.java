/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snix.snixtennis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.lang.Exception;
import java.util.List;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

/**
 *
 * @author sauma
 */
@Configuration

public class WebConfig implements WebMvcConfigurer {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("https://snixshop.com", " https://snixshop.com", "https://snixshop.com/productos.html", "https://snixshop.com/detallesProducto.html")
                .allowedMethods("POST", "PUT", "GET", "OPTIONS", "DELETE")
                .allowedHeaders("Authorization", "Content-type", "Accept", "X-Requested-With", "Cache-Control", "X-XSRF-TOKEN", "X-CSRF-TOKEN")
                .exposedHeaders("Authorization", "Content-Disposition", "X-Total-Count")
                .allowCredentials(true)
                .maxAge(3600);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        try {

            return security
                    //formLogin(form -> form
                    //            .loginPage("/login")
                    //            .usernameParameter("username")
                    //            .passwordParameter("password")
                    //            .failureUrl("/login?=error")
                    //            .defaultSuccessUrl("/admin")
                    //            .permitAll()
                    //           )      
                    .cors(Customizer.withDefaults())
                    .csrf(csrf -> csrf.disable())
                    .authorizeHttpRequests(res -> res
                    .requestMatchers(HttpMethod.GET, "/home/**", "/js/**", "/css/**", "/images/**", "/login/**", "/static/**", "/admin/**", "/admin/registrarProducto").permitAll()
           
                    .requestMatchers(HttpMethod.POST, "/admin/**", "home/producto/**").permitAll()
                    .requestMatchers(HttpMethod.DELETE, "/admin/**","home/producto/**").permitAll()
                    .requestMatchers(HttpMethod.PUT, "/admin/**","home/producto/**").permitAll()
                    .anyRequest().authenticated())
                    .build();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }
}
