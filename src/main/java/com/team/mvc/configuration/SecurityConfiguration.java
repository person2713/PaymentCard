package com.team.mvc.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    CustomSuccessHandler customSuccessHandler;

    @Autowired
    CustomFailureHandler customFailureHandler;

    @Autowired
    @Qualifier("customUserDetailsService")
    UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/home","/newPassword/**","/welcome", "/updPass/**").permitAll().and()
        .authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN").and()
                .authorizeRequests() .antMatchers("/user/**").hasRole("USER").and()
                .authorizeRequests().antMatchers("/driver/**").hasRole("DRIVER").and()
                .authorizeRequests().antMatchers("/API/**").hasRole("DRIVER").and()
                .authorizeRequests() .antMatchers("/owner/**").hasRole("OWNER")
                .and().formLogin().loginPage("/login").successHandler(customSuccessHandler)
                .failureHandler(customFailureHandler)
                .usernameParameter("nickName").passwordParameter("password")
                .and().httpBasic()
                .and().csrf()
                .and().exceptionHandling().accessDeniedPage("/Access_Denied");
    }

    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/API/driverLogin/csrf-token")
                .antMatchers("/API/getBlockedCards")
        ;
    }

    @Bean
    public AuthenticationTrustResolver getAuthenticationTrustResolver() {
        return new AuthenticationTrustResolverImpl();
    }


}
