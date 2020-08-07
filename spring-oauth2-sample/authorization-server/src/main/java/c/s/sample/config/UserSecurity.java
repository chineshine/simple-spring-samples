package c.s.sample.config;

import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

/**
 * @author chineshine
 * @date 2019年12月27日
 *
 */
//@Order(4)
@Configuration
@EnableWebSecurity(debug = true)
public class UserSecurity extends WebSecurityConfigurerAdapter {

	private @Autowired DataSource dataSource;

	private @Autowired PasswordEncoder passwordEncoder;
	
	private @Autowired KeyPair keyPair;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
//			.antMatcher("/**").authorizeRequests().antMatchers("/oauth/authorize**", "/login**", "/error**").permitAll()
//			.and()
			.authorizeRequests().mvcMatchers("/.well-known/jwks.json", "/actuator", "/actuator/**", "/h2-console", "/h2-console/**")
				.permitAll()
			.anyRequest().authenticated();

		http.httpBasic().and().formLogin();
		http.oauth2ResourceServer(
				r-> r.jwt(jwt ->
				jwt.decoder(jwtDecoder()))
				);
		
			http.csrf()
				.ignoringRequestMatchers(request -> "/introspect".equals(request.getRequestURI()))
				.ignoringAntMatchers("/h2-console", "/h2-console/**")
			.and()
			.headers(headers -> headers.frameOptions().sameOrigin());
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder).withDefaultSchema()
				.withUser("admin").password(passwordEncoder.encode("admin")).authorities("*:*");
	}

	@Bean
	public JwtDecoder jwtDecoder() {
		RSAPublicKey publicKey = (RSAPublicKey) this.keyPair.getPublic();
		return NimbusJwtDecoder.withPublicKey(publicKey).build();
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}
