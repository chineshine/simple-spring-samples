package c.s.sample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author chineshine
 * @date 2019年12月24日
 *
 */
@Configuration
@EnableWebSecurity
public class ResourceServerConfig extends WebSecurityConfigurerAdapter  {


	@Override
	public void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().anyRequest().authenticated().and().oauth2ResourceServer(oauth2ResourceServer-> oauth2ResourceServer.jwt(jwt->jwt.jwkSetUri(jwkSetUri)));
//		http.authorizeRequests(authRequest -> authRequest.anyRequest().authenticated()).oauth2ResourceServer(
//				oauth2ResourceServer -> oauth2ResourceServer.jwt(jwt -> jwt.decoder(jwtDecoder())));
		http.authorizeRequests().anyRequest().authenticated()
			.and()
			.oauth2ResourceServer().jwt();
	}

	
}
