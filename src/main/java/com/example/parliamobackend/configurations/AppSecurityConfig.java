package com.example.parliamobackend.configurations;


import com.example.parliamobackend.user.UserService;
import com.example.parliamobackend.user.UserServiceImpl;
import com.example.parliamobackend.user.authorities.UserRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@EnableWebMvc
// Enables @PreAuthorize
public class AppSecurityConfig {

    private final AppPasswordConfig bcrypt;
    private final UserServiceImpl userService;



    @Autowired
    public AppSecurityConfig(AppPasswordConfig bcrypt, UserServiceImpl userService) {
        this.bcrypt = bcrypt;
        this.userService = userService;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(
                        "/", "/login", "/error",
                        "/rest/encode", "/user", "/message",
                        "/user/register"
                )
                .permitAll()
                .requestMatchers("/admin")
                .hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();

                // TODO - Tell Spring Security, which implementation, for password: to use


        return http.build();

    }

    public DaoAuthenticationProvider authenticationOverride() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        provider.setUserDetailsService(userService);            // Query
        provider.setPasswordEncoder(bcrypt.bCryptPasswordEncoder()); // Encoder BCRYPT

        return provider;
    }


}
