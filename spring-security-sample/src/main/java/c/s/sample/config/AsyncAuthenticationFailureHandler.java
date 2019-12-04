package c.s.sample.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

/**
 * @author chineshine
 * @date 2019年12月2日
 *
 */
public class AsyncAuthenticationFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		// 异步调用  失败返回 403
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//		response.sendError(HttpServletResponse.SC_FORBIDDEN, exception.getMessage());
		response.getWriter().print(exception.getMessage());
	}

}
