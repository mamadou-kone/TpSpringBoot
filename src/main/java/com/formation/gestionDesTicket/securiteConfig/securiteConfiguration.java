package com.formation.gestionDesTicket.securiteConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class securiteConfiguration {
    @Autowired
    private UserDetailsService userDetailsService;
    @Bean
    public DefaultSecurityFilterChain matcherSecurityWebFilterChain(HttpSecurity httpSecurity) throws Exception {
     httpSecurity
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(registry -> {
        registry.requestMatchers("/user/**").permitAll();
        registry.requestMatchers("/admin/**").hasRole("ADMIN");
        registry.requestMatchers("/apprenant/**").hasRole("FORMATEUR");
        registry.requestMatchers("/ticket/**").permitAll();
        registry.requestMatchers("/baseConnaissace/**").hasRole("FORMATEUR");
        registry.requestMatchers("/formateur/**").hasRole("ADMIN");
        registry.requestMatchers("/categorie").hasRole("FORMATEUR");
        registry.requestMatchers("/priorite/**").hasRole("FORMATEUR");
        registry.anyRequest().authenticated();
    })
             .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
            .httpBasic(withDefaults());
           return  httpSecurity.build();
    }
   /* @Bean
    public UserDetailsService userDetailsService(){
        UserDetails admin= User.builder()
                .username("admin")
                .password("$2a$12$JTCEAnTWrq8RqfmR4RjiBeGhhfgwMU0gNZv9ODSwTM84UAMIkIEfy")
                .roles("ADMIN")
                .build();
        UserDetails formateur= User.builder()
                .username("formateur")
                .password("$2a$12$JTCEAnTWrq8RqfmR4RjiBeGhhfgwMU0gNZv9ODSwTM84UAMIkIEfy")
                .roles("FORMATEUR")
                .build();
        UserDetails apprenant= User.builder()
                .username("apprenant")
                .password("$2a$12$JTCEAnTWrq8RqfmR4RjiBeGhhfgwMU0gNZv9ODSwTM84UAMIkIEfy")
                .roles("APPRENANT")
                .build();
        return new InMemoryUserDetailsManager(admin,apprenant,formateur);
    }*/

    @Bean
    public UserDetailsService userDetailsService(){
        return userDetailsService;
    }
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
