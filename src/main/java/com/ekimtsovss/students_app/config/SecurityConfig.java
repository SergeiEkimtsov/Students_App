package com.ekimtsovss.students_app.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity

public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(final HttpSecurity http) throws Exception{
        String [] adminPermit= {"/updateStudent","/application", "/deleteStudent"};
        return http.authorizeHttpRequests(auth->auth
                        .requestMatchers("/getAll").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(adminPermit).hasAnyRole("ADMIN")
                        .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .build();
    }

@Bean
   public UserDetailsService userDetailsService(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
   }
//    UserDetails user1 =
//            User.builder()
//                    .username("admin")
//                    .password("{bcrypt}$2a$12$CVMkPdYBBV7pyOOYet5JbOPXUHZRkiO3rvyG13s3OV5jzUYM2aiVe")
//                    .roles("ADMIN")
//                    .build();
//    UserDetails user2 =
//            User.builder()
//                    .username("user")
//                    .password("{bcrypt}$2a$12$gpuLLxU6ar4TJ7xW8n5YB.Fli3v31wV/.292sU27CgxHqWsZuAJ.O")
//                    .roles("USER")
//                    .build();
//    List<UserDetails> userList = List.of(user2,user1);
//
//    return new InMemoryUserDetailsManager(userList);
//}


}