package c.s.sample.certificate;

import java.util.Collections;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.util.Assert;

public class CertificateProvider implements AuthenticationProvider{

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	
		Assert.isInstanceOf(CertificateToken.class, authentication, "Only CertificateToken is supported");
		CertificateToken authRequest = (CertificateToken) authentication;
		
		// TODO 处理证书认证
		
		User user = new User("username", "password", Collections.emptyList());
		
		CertificateToken token = new CertificateToken(authRequest.getPrincipal(), authRequest.getCredentials(), Collections.emptyList());
		token.setDetails(user);
		return token;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return CertificateToken.class.isAssignableFrom(authentication);
	}

}
