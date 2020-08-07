package c.s.sample.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

/**
 * @author chineshine
 * @since  2020年8月5日
 */
@SuppressWarnings({ "all" })
//@EnableOAuth2Client
//@Configuration
public class OAuth2Client2Config {
	
	@ConfigurationProperties(prefix = "oauth2.client.client1")
	@Bean("authorizationCodeClient1")
	public OAuth2ProtectedResourceDetails authorizationCodeClient1() {
		return new AuthorizationCodeResourceDetails();
	}


	@Bean("client1RestTemplate")
	public OAuth2RestOperations client1RestTemplate(OAuth2ClientContext oAuth2ClientContext,
			@Qualifier("authorizationCodeClient1")OAuth2ProtectedResourceDetails protectedResourceDetails ) {
		return new OAuth2RestTemplate(protectedResourceDetails, oAuth2ClientContext);
		
	}
}
