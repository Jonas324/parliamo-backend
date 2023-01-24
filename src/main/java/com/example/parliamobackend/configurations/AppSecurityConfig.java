package com.example.parliamobackend.configurations;


import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@EnableWebMvc
// Enables @PreAuthorize
public class AppSecurityConfig {
    private final AppPasswordConfig appPasswordConfig;

    @Autowired
    public AppSecurityConfig(AppPasswordConfig appPasswordConfig) {
        this.appPasswordConfig = appPasswordConfig;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/", "/login", "/error", "/rest/encode", "/user", "/message")
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

    @Bean
    public UserDetailsService createUsersInMemory() {

        UserDetails benny = User.withDefaultPasswordEncoder()
                .username("benny")
                .password(appPasswordConfig.bCryptPasswordEncoder().encode("123"))
                .roles("ADMIN")
                // <-- old way (only role)
                //.authorities(UserRoles.ADMIN.getGrantedAuthorities())   // <-- new way (both permissions and role)
                .build();

        return new InMemoryUserDetailsManager(benny);
    }

}
