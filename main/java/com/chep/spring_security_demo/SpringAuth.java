package com.chep.spring_security_demo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringAuth {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/demo", "/demo/ONE").permitAll() // Use requestMatchers instead of antMatchers
                        .anyRequest().authenticated() // All other requests need authentication
                )
                .formLogin(Customizer.withDefaults()); // Enables form-based login

        return http.build();
    }

    @Bean //this acts as the filter chain of which paths should be secured.
    public InMemoryUserDetailsManager inMemoryUserDetailsManager()

    {
        // logout option is provided by default
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        UserDetails user1 = users
                .username("testUser1")
                .password("password1")
                .roles("USER")
                .build();
        UserDetails user2 = users
                .username("testUser2")
                .password("password")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user1,user2);
    }
}





