package com.room001.freetimeproject;

import com.room001.freetimeproject.Util.JwtRequestFilter;
import com.room001.freetimeproject.Util.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SpringBootApplication
public class FreeTimeProjectApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(FreeTimeProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }

    @EnableWebSecurity
    class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        private MyUserDetailsService myUserDetailsService;
        @Autowired
        private JwtRequestFilter jwtRequestFilter;

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(myUserDetailsService);
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
            return NoOpPasswordEncoder.getInstance();
        }

        @Override
        @Bean
        public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
        }

        // here you add endpoint that you can call without auth
        @Override
        protected void configure(HttpSecurity httpSecurity) throws Exception {
            httpSecurity.csrf().disable().authorizeRequests()
                    .antMatchers("/login").permitAll()
                    .antMatchers("/register").permitAll().
                    anyRequest().authenticated().and().
                    exceptionHandling().and().sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        }
    }
}
