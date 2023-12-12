package com.example.demo.security.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.security.service.User_UserDetails_Service;


@Configuration
@EnableWebSecurity
public class  SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private User_UserDetails_Service userService;

    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public CustomAccessDeniedHandler customAccessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/", "/login", "/register", "/movie-details").permitAll()
                .antMatchers("/user/**").hasRole("CLIENT")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
            .and()  
            .formLogin()
                .loginPage("/login") //Trang login
                .defaultSuccessUrl("/logincheck?error=0")//Đăng nhập thành công
                .failureUrl("/logincheck?error=1") ////Đăng nhập thất bại
                .permitAll() 
            .and()
            .logout()
                .logoutUrl("/logout") //Trang logout
                .logoutSuccessUrl("/logout-success") //Đăng xuất thành công
                .permitAll()  
            .and()
                .exceptionHandling()
                .accessDeniedHandler(customAccessDeniedHandler());   //Access denied handler
    }
}
