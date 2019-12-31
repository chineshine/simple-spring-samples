package c.s.sample.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author chineshine
 * @date 2019年12月27日
 *
 */
@Order(2)
@Configuration
@EnableWebSecurity
public class UserSecurity extends WebSecurityConfigurerAdapter {

	private @Autowired DataSource dataSource;
	
	private @Autowired PasswordEncoder passwordEncoder;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
			.mvcMatchers("/.well-known/jwks.json","/actuator","/actuator/**","/h2-console","/h2-console/**").permitAll()
			.anyRequest().authenticated()
			.and()
		.httpBasic()
			.and()
		.csrf().ignoringRequestMatchers(request -> "/introspect".equals(request.getRequestURI()))
			.ignoringAntMatchers("/h2-console","/h2-console/**")
		.and().headers(headers->headers.frameOptions().sameOrigin());
	}


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder).withDefaultSchema()
				.withUser("admin").password(passwordEncoder.encode("admin")).authorities("*:*");
	}

}
