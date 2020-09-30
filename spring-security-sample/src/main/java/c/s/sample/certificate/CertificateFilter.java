package c.s.sample.certificate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.lang.Nullable;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CertificateFilter extends AbstractAuthenticationProcessingFilter {

	private String usernameParameter = "username";
	private String passwordParameter = "password";
	private String fileParameter = "file";
	private boolean postOnly = true;

	protected CertificateFilter() {
		super(new AntPathRequestMatcher("/login", "POST"));
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		if (postOnly && !"post".equalsIgnoreCase(request.getMethod())) {
			throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
		}

		String username = obtainUsername(request);
		String password = obtainPassword(request);

		Part file = obtainFile(request);

		CertificateToken authRequest = new CertificateToken(username, password, file);

		setDetails(request, authRequest);
		return getAuthenticationManager().authenticate(authRequest);
	}

	@Nullable
	protected String obtainUsername(HttpServletRequest request) {
		return request.getParameter(usernameParameter);
	}

	@Nullable
	protected String obtainPassword(HttpServletRequest request) {
		return request.getParameter(passwordParameter);
	}

	@Nullable
	protected Part obtainFile(HttpServletRequest request) {
		try {
			return request.getPart(fileParameter);
		} catch (IOException | ServletException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	protected void setDetails(HttpServletRequest request, CertificateToken authRequest) {
		authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
	}

}
