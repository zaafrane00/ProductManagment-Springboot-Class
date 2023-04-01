package com.productmanager.gestionproduits.security;



import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.inMemoryAuthentication().withUser("user1").password(encoder().encode("123")).roles("USER");
        //auth.inMemoryAuthentication().withUser("admin").password(encoder().encode("123")).roles("ADMIN");
        auth.userDetailsService(userDetailsService);

    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin()
//                .defaultSuccessUrl("/home");
//
//        http.logout()
//                .logoutSuccessUrl("/");
//
//        http.authorizeRequests()
//                .antMatchers("/","/index","/images/**")
//                .permitAll();
//
//        http.authorizeRequests()
//                .antMatchers("/delete/**","/addProduct","/save","/edit/**")
//                .hasAuthority("ADMIN");
        //.hasRole("ADMIN");

//        http.authorizeRequests()
//                .anyRequest()
//                .authenticated();

        http.formLogin().disable();
        http.csrf().disable();
    }

    @Bean
    PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}
