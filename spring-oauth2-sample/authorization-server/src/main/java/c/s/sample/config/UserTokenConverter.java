package c.s.sample.config;

import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;

/**
 * @author chineshine
 * @date 2019年12月26日
 *
 */
public class UserTokenConverter extends DefaultUserAuthenticationConverter{

	@Override
	public Map<String, ?> convertUserAuthentication(Authentication authentication) {
		return super.convertUserAuthentication(authentication);
	}
}
