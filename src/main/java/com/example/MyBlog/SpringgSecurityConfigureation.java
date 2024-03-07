package com.example.MyBlog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

@Configuration
@EnableWebSecurity
public class SpringgSecurityConfigureation {

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {

        Function<String, String> passwordEncoder =
                input -> passwordEncoder().encode(input);

        UserDetails userDetails1 = User.builder()
                .passwordEncoder(passwordEncoder)
                .username("admin")
                .password("admin")
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(userDetails1);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                requests ->
                        requests.requestMatchers("/Post" , "/Post/*" , "/Post/newComment/*").permitAll()
                                .anyRequest().authenticated()
        )
                .formLogin(Customizer.withDefaults())
                .logout(Customizer.withDefaults());



        return http.build();

}
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
