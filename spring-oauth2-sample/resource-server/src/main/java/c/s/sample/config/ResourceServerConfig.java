package c.s.sample.config;

import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

/**
 * @author chineshine
 * @date 2019年12月24日
 *
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Value("${spring.security.oauth2.resourceserver.jwt.jwk-set-uri}")
	String jwkSetUri;

	private String checkTokenEndPoint = "http://localhost:8080/oauth/token_key";
	
	private String remoteTokenKeyEndPoint = "";
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//		resources.
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().anyRequest().authenticated().and().oauth2ResourceServer(oauth2ResourceServer-> oauth2ResourceServer.jwt(jwt->jwt.jwkSetUri(jwkSetUri)));
		http.authorizeRequests(authRequest -> authRequest.anyRequest().authenticated()).oauth2ResourceServer(
				oauth2ResourceServer -> oauth2ResourceServer.jwt(jwt -> jwt.decoder(jwtDecoder())));
	}

	@Bean
	JwtDecoder jwtDecoder() {
		return NimbusJwtDecoder.withJwkSetUri(jwkSetUri).build();
	}
	
	@Bean
	RemoteTokenServices remoteTokenServices() {
		RemoteTokenServices tokenServices = new RemoteTokenServices();
		tokenServices.setCheckTokenEndpointUrl(checkTokenEndPoint);
		return tokenServices;
	}
	
	JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
		accessTokenConverter.setVerifierKey("");
		return accessTokenConverter;
	}

	
}
