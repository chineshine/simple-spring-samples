package c.s.sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author chineshine
 * @date 2019年12月2日
 *
 */
@SuppressWarnings("all")
@EnableWebSecurity(debug = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests(
				authorizeRequests -> 
					authorizeRequests.antMatchers("/css/**", "/index").permitAll()
					.antMatchers("/**").authenticated())
				.formLogin(formLogin -> formLogin.loginProcessingUrl("/signIn")
						.successHandler(new AsyncAuthenticationSuccessHandler())
						.failureHandler(new AsyncAuthenticationFailureHandler()));
		http.csrf().disable();
	}

	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		UserDetails userDetails = User.withDefaultPasswordEncoder().username("user").password("123456").roles("USER")
				.build();
		return new InMemoryUserDetailsManager(userDetails);
	}

}
