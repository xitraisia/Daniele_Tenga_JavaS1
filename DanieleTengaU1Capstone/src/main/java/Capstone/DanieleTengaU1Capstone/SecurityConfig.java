package Capstone.DanieleTengaU1Capstone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder authBuilder) throws Exception {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        authBuilder.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(
                        "select username, password, enabled from users where username = ?")
                .authoritiesByUsernameQuery(
                        "select username, authority from authorities where username = ?")
                .passwordEncoder(encoder)
                .csrf().disable();
    }

    //USER,Searching
    //STAFF_MEMBER,updates
    //Manager,create
    //ADMIN,delete
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic();
        httpSecurity.authorizeRequests()
//                //Login
//                .mvcMatchers("/login").hasAuthority("USER")
//                .mvcMatchers("/login").hasAuthority("ADMIN")
//                .mvcMatchers("/login").hasAuthority("STAFF_MEMBER")
//                .mvcMatchers("/login").hasAuthority("MANAGER")
                //USER,Searching
                .mvcMatchers("/console/*").hasAuthority("USER")
                .mvcMatchers("/console/m/*").hasAuthority("USER")
                .mvcMatchers("/game/*").hasAuthority("USER")
                .mvcMatchers("/game/studio/*").hasAuthority("USER")
                .mvcMatchers("/game/esrb/*").hasAuthority("USER")
                .mvcMatchers("/game/title/*").hasAuthority("USER")
                .mvcMatchers("/tshirt/*").hasAuthority("USER")
                .mvcMatchers("/tshirt/color/*").hasAuthority("USER")
                .mvcMatchers("/tshirt/size/*").hasAuthority("USER")
                //STAFF_MEMBER,updates
                .mvcMatchers(HttpMethod.PUT ,"/console/*").hasAuthority("STAFF_MEMBER")
                .mvcMatchers(HttpMethod.PUT ,"/game/*").hasAuthority("STAFF_MEMBER")
                .mvcMatchers(HttpMethod.PUT ,"/tshirt/*").hasAuthority("STAFF_MEMBER")
                //Manager,create
                .mvcMatchers(HttpMethod.POST ,"/console").hasAuthority("MANAGER")
                .mvcMatchers(HttpMethod.POST ,"/game").hasAuthority("MANAGER")
                .mvcMatchers(HttpMethod.POST ,"/tshirt").hasAuthority("MANAGER")
                //ADMIN,delete
                .mvcMatchers(HttpMethod.DELETE,"/console/*").hasAuthority("ADMIN")
                .mvcMatchers(HttpMethod.DELETE,"/game/*").hasAuthority("ADMIN")
                .mvcMatchers(HttpMethod.DELETE,"/tshirt/size/*").hasAuthority("ADMIN")
                .anyRequest().permitAll();
        httpSecurity
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
        httpSecurity
                .logout()
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/allDone")
                .deleteCookies("JSESSIONID")
                .deleteCookies("XSRF-TOKEN")
                .invalidateHttpSession(true);
    }
}
