package c.s.sample.config;

import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import com.nimbusds.jose.jwk.RSAKey;


/**
 * @author chineshine
 * @date 2019年12月25日
 *
 */
@Configuration
public class GeneralConfig {

	private static final String KEY_FILE_NAME = "authserver.jks";
	private static final String KEY_STORE_PASSWORD = "cs123456";
	private static final String KEY_ALIAS = "authserver";

	@Bean
	KeyPair keyPair() {
		Resource resource = new ClassPathResource(KEY_FILE_NAME);
		KeyStoreKeyFactory keyFactory = new KeyStoreKeyFactory(resource, KEY_STORE_PASSWORD.toCharArray());
		return keyFactory.getKeyPair(KEY_ALIAS);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	public static void main(String[] args) {
		RSAPublicKey publicKey = (RSAPublicKey) new GeneralConfig().keyPair().getPublic();
		RSAKey key = new RSAKey.Builder(publicKey).build();
//		System.out.println(new JWKSet(key).toJSONObject());
	
		PasswordEncoder passwordEncoder = new GeneralConfig().passwordEncoder();
//		System.out.println(passwordEncoder.encode("123456"));
		
		String pass = "{bcrypt}$2a$10$goBwnQxOGETuhYHkLv2wbO9N/kE2LfgO7/a9EhuFSem0bKh8Yi7BK";
		System.out.println(passwordEncoder.matches("123456", pass));

//		System.out.println(new Integer(600_000_000));
	}
		
	
	
}
