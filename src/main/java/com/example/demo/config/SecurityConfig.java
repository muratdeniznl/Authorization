package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth)
//            throws Exception {
//                auth
//                .inMemoryAuthentication()
//                .withUser("broekhuis").password(passwordEncoder().encode("broekhuis")).roles("USER")
//                .and()
//                .withUser("admin").password(passwordEncoder().encode("admin")).roles("USER","ADMIN");
//    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1 =
                User.builder()
                        .username("user")
                        .password(passwordEncoder().encode("user"))
                        .roles("USER")
                        .build();
        UserDetails user2 =
                User.builder()
                        .username("admin")
                        .password(passwordEncoder().encode("admin"))
                        .roles("USER", "ADMIN")
                        .build();
        return new InMemoryUserDetailsManager(user1, user2);
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
        http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/"
                        , "/h2-console/**"
                        , "/console/**"
                        , "/contact"
                        , "/blog"
                        , "/js/**"
                        , "/css/**"
                        , "/api/**"
                        ,"/v3/api-docs/**",
                        "/swagger-ui.html",
                        "/swagger-ui/**",
                        "/webjars/**"
                ).permitAll()
                .requestMatchers("/customer*", "/room*").hasAnyRole("USER", "ADMIN")
                .requestMatchers("/reservation*").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/home")
                .invalidateHttpSession(true)
                .permitAll()
        ;

        return http.build();

    }
}