package c.s.sample.certificate;

import java.util.Collection;

import javax.servlet.http.Part;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;

import lombok.Getter;

public class CertificateToken extends AbstractAuthenticationToken {

	public CertificateToken(Object principal, Object credentials,Part file) {
		super(null);
		this.principal = principal;
		this.credentials = credentials;
		this.file = file;
		setAuthenticated(false);
	}

	public CertificateToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
		this.principal = principal;
		this.credentials = credentials;
		super.setAuthenticated(true);
	}

	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		if (isAuthenticated) {
			throw new IllegalArgumentException(
					"Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
		}

		super.setAuthenticated(false);
	}

	private final Object principal;
	
	private Object credentials;

	/**
	 * 证书文件
	 */
	@Getter
	private Part file;
	
	@Override
	public Object getCredentials() {
		return credentials;
	}

	@Override
	public Object getPrincipal() {
		return principal;
	}
}
