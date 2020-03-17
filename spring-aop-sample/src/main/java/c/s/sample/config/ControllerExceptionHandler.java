package c.s.sample.config;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import c.s.sample.exception.SampleException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author chineshine
 * @since  2020年3月17日
 */
@Slf4j
//@ControllerAdvice
@RestControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(SampleException.class)
	public HttpEntity<Response> handleException(SampleException e) {
		log.error(e.getErrorCode().getCode() + ": " + e.getMessage(), e);
		Response response = new Response();
		response.setMessage(e.getMessage());
		response.setCode(e.getErrorCode().getCode());
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Data
	public class Response {
		private String message;

		private String code;
	}
}
