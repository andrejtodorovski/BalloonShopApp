package mk.ukim.finki.veblabs;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity security) throws Exception
    {
        security.csrf().disable().authorizeRequests()
                .antMatchers("/","/register" ,"/balloons", "/login", "/balloon", "/balloonOrder", "/confirmationInfo", "/manufacturers","/selectBalloon").permitAll()
                .antMatchers("/orders","/balloons/add-form", "/balloons/edit-form/**").authenticated()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").permitAll()
                .failureUrl("/login?error=BadCredentials")
                .defaultSuccessUrl("/balloon")
                .and()
                .logout()
                .logoutUrl("logout").clearAuthentication(true).invalidateHttpSession(true).deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/login")
                .and()
                .exceptionHandling().accessDeniedPage("/login");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("andrej").password(passwordEncoder.encode("andrej"))
                .authorities("ROLE_ADMIN")
                .and()
                .withUser("bojan").password(passwordEncoder.encode("bojan"))
                .authorities("ROLE_USER");
    }

}
