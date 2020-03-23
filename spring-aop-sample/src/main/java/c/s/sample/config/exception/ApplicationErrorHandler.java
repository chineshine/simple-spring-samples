package c.s.sample.config.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import c.s.sample.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;

/**
 * 该 controller 是利用 spring 内部机制,spring 内部会将所有异常请求定位到 /error,故而在此处处理异常结果
 * @author chineshine
 * @since  2020年3月18日
 */
@Slf4j
@RestController
public class ApplicationErrorHandler extends AbstractErrorHandler {
	private final String ERROR_PATH = "/error";

	public ApplicationErrorHandler(ErrorAttributes errorAttributes) {
		super(errorAttributes);
	}

	@GetMapping(ERROR_PATH)
	public HttpEntity<Response> handleError(HttpServletRequest httpServletRequest) {
		HttpStatus status = getStatus(httpServletRequest);
		log.error("当前 http 请求的状态是: " + status);
		Response response = null;

		switch (status) {
		case NOT_FOUND:
			response = new Response(ErrorCode.requestNotFound, "请求不存在");
			break;
		case METHOD_NOT_ALLOWED:
			response = new Response(ErrorCode.methodNotAllow, "请求方式不被允许");
			break;
		default:
			String message = getExceptionMessage(httpServletRequest);
			response = new Response(ErrorCode.requestInternalError, message);
			break;
		}
		return new ResponseEntity<Response>(response, status);
	}

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}
}
