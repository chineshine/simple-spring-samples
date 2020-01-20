package c.s.sample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
//@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//			.authorizeRequests().anyRequest().authenticated()
//			.and()
//			.formLogin(
//					f -> f
//					 .loginPage("/login")
//					 .failureUrl("/error")
//					)
//			.httpBasic()
//			.and()
//			.oauth2Client();
//	}
}
