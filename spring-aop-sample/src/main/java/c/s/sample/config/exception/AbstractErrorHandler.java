package c.s.sample.config.exception;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

/**
 * @author chineshine
 * @since  2020年3月23日
 */
public abstract class AbstractErrorHandler implements ErrorController {

	private final ErrorAttributes errorAttributes;

	public AbstractErrorHandler(ErrorAttributes errorAttributes) {
		this.errorAttributes = errorAttributes;
	}

	protected Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
		WebRequest webRequest = new ServletWebRequest(request);
		return this.errorAttributes.getErrorAttributes(webRequest, includeStackTrace);
	}

	protected boolean getTraceParameter(HttpServletRequest request) {
		String parameter = request.getParameter("trace");
		if (parameter == null) {
			return false;
		}
		return !"false".equalsIgnoreCase(parameter);
	}

	protected HttpStatus getStatus(HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		if (statusCode == null) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		try {
			return HttpStatus.valueOf(statusCode);
		} catch (Exception ex) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
	}

	/**
	 * 获取异常抛出时的报错信息,不包括堆栈信息
	 * @param request
	 *          http request
	 * @return
	 */
	protected String getExceptionMessage(HttpServletRequest request) {
		Map<String, Object> map = getErrorAttributes(request, false);
		return map.getOrDefault("message", "系统内部错误").toString();
	}

}
