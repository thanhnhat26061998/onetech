package vn.com.onetech.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/").permitAll()               
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/admin/productdetail").hasRole("ADMIN")
                .antMatchers("/admin/product").hasRole("ADMIN")
                .antMatchers("/admin/addproductDt").hasRole("ADMIN")
                .antMatchers("/admin/order").hasRole("ADMIN")
                .and()
            .formLogin()
            	.loginPage("/login")
            	.usernameParameter("email")
            	.passwordParameter("password")
            	.failureUrl("/login?error")
            	.and()
            .logout()

				.permitAll()
				.and()
        	.exceptionHandling()
    			.accessDeniedPage("/403");
    }
	
}
