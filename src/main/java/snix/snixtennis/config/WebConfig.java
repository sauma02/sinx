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

/**
 *
 * @author sauma
 */
@Configuration

public class WebConfig implements WebMvcConfigurer {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception{
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
                    .authorizeHttpRequests(res -> res
                    .requestMatchers("/home/**", "/js/**", "/css/**", "/images/**", "/login/**","/static/**","/admin/**").permitAll()
                    .anyRequest().authenticated())
                    .build();
        } catch (Exception e) {
            throw new Exception("Error: "+e.getMessage());
        }
    }
}
