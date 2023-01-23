package com.example.parliamobackend.configurations;

import com.example.parliamobackend.user.authorities.UserRoles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity                   // Enables @PreAuthorize
public class AppSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .requestMatchers("/", "/login", "/error", "/rest/encode", "/user", "/message").permitAll()
                .requestMatchers("/admin").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();

                // TODO - Tell Spring Security, which implementation, for password: to use


        return http.build();

    }

    @Bean
    public UserDetailsService createUsersInMemory() {

        UserDetails benny = User.withDefaultPasswordEncoder()
                .username("benny")
                .password("123")
                // .roles("ADMIN")                                      // <-- old way (only role)
                .authorities(UserRoles.ADMIN.getGrantedAuthorities())   // <-- new way (both permissions and role)
                .build();

        UserDetails anton = User.withDefaultPasswordEncoder()
                .username("anton")
                .password("123")
                .authorities(UserRoles.USER.getGrantedAuthorities())
                .build();

        return new InMemoryUserDetailsManager(benny, anton);
    }

}
