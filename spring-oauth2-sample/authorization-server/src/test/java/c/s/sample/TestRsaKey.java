package c.s.sample;

import java.security.interfaces.RSAPublicKey;

import org.junit.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;

import c.s.sample.config.GeneralConfig;

/**
 * @author chineshine
 * @date 2019年12月5日
 *
 */
public class TestRsaKey {

	@Test
	public void test1() {
		RSAPublicKey publicKey = (RSAPublicKey) new GeneralConfig().keyPair().getPublic();
		RSAKey key = new RSAKey.Builder(publicKey).build();
		System.out.println(new JWKSet(key).toJSONObject());
	
		PasswordEncoder passwordEncoder = new GeneralConfig().passwordEncoder();
//		System.out.println(passwordEncoder.encode("123456"));
		
		String pass = "{bcrypt}$2a$10$goBwnQxOGETuhYHkLv2wbO9N/kE2LfgO7/a9EhuFSem0bKh8Yi7BK";
		System.out.println(passwordEncoder.matches("123456", pass));

	}
}
