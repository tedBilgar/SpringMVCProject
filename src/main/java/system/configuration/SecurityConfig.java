package system.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import system.service.SpringDataUserDetailsService;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   @Autowired
   private SpringDataUserDetailsService springDataUserDetailsService;
   @Autowired
   private BCryptPasswordEncoder bCryptPasswordEncoder;

   @Override
   protected void configure(AuthenticationManagerBuilder auth)
           throws Exception {
       auth.userDetailsService(springDataUserDetailsService)
               .passwordEncoder(bCryptPasswordEncoder);
               /*.inMemoryAuthentication()
               .withUser("user").password("{noop}123456").roles("USER").and()
               .withUser("admin").password("password").roles("USER", "ADMIN");*/
   }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                .and()
                .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/")
                    .permitAll();
    }
}
