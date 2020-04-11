package newsplatform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsService userDetailsService;
     @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
         auth.userDetailsService(userDetailsService);
     }
     @Override
    protected void configure(HttpSecurity http) throws Exception {
         http
                 .authorizeRequests()
                 .antMatchers("/").hasAuthority("ADMIN")
                 .antMatchers("/delete/**").hasAuthority("ADMIN")
                 .antMatchers("/getAllUsers").hasAuthority("ADMIN")
                 .antMatchers("/postNews").hasAnyAuthority("USER","ADMIN")
                 .antMatchers("/news/{newsId}/comment").hasAnyAuthority("USER","ADMIN")
                 .antMatchers("/page={page}").permitAll()
                 .antMatchers("/news/{newsId}").permitAll()
                 .and()
                 .csrf().disable()
                 .formLogin()
                 .and()
                 .httpBasic()
                 .and()
                 .logout();

     }
     @Bean
    public PasswordEncoder getPasswordEncoder (){
         return new BCryptPasswordEncoder();
     }

}
