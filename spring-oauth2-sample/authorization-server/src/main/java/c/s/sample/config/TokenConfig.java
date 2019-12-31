package c.s.sample.config;

import java.security.KeyPair;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @author chineshine
 * @date 2019年12月25日
 *
 */
@Configuration
public class TokenConfig {

	@Autowired
	private KeyPair keyPair;
	
	
	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
		accessTokenConverter.setKeyPair(keyPair);
		DefaultAccessTokenConverter defaultAccessTokenConverter = new DefaultAccessTokenConverter();
		defaultAccessTokenConverter.setUserTokenConverter(new UserTokenConverter());
		return accessTokenConverter;
	}
}
