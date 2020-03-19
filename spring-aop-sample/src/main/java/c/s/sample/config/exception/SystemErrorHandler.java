package c.s.sample.config.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
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
public class SystemErrorHandler implements ErrorController {
	private final String ERROR_PATH = "/error";

	@GetMapping(ERROR_PATH)
	public HttpEntity<Response> handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		int statusCode = httpServletResponse.getStatus();
		HttpStatus status = HttpStatus.valueOf(statusCode);
		log.error("返回的状态码(statusCode)为: " + status);
		Response response = null;
		switch (status) {
		case NOT_FOUND:
			response = new Response(ErrorCode.requestNotFound, "请求不存在");
			break;
		case INTERNAL_SERVER_ERROR:
			response = new Response(ErrorCode.requestInternalError, "服务内部错误");
			break;
		case METHOD_NOT_ALLOWED:
			response = new Response(ErrorCode.methodNotAllow, "请求方式不被允许");
			break;
		default:
			response = new Response(ErrorCode.requestInternalError, "服务内部错误");
			break;
		}

		return new ResponseEntity<Response>(response, status);

	}

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}
}
