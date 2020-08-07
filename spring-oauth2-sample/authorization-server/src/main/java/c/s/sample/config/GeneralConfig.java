package c.s.sample.config;

import java.security.KeyPair;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;



/**
 * @author chineshine
 * @date 2019年12月25日
 *
 */
@Configuration
@SuppressWarnings("deprecation")
public class GeneralConfig {

	private static final String KEY_FILE_NAME = "authserver.jks";
	private static final String KEY_STORE_PASSWORD = "cs123456";
	private static final String KEY_ALIAS = "authserver";

	@Bean
	public KeyPair keyPair() {
		Resource resource = new ClassPathResource(KEY_FILE_NAME);
		KeyStoreKeyFactory keyFactory = new KeyStoreKeyFactory(resource, KEY_STORE_PASSWORD.toCharArray());
		return keyFactory.getKeyPair(KEY_ALIAS);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	
}
