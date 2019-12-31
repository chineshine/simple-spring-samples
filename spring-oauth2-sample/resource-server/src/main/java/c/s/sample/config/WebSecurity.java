package c.s.sample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;

/**
 * @author chineshine
 * @date 2019年12月31日
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{

	
	@Override
		protected void configure(HttpSecurity http) throws Exception {
			super.configure(http);
			http.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
		}
	
}
