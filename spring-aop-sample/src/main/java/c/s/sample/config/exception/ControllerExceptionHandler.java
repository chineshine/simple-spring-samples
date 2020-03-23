package c.s.sample.config.exception;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import c.s.sample.exception.AuthException;
import c.s.sample.exception.SampleException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author chineshine
 * @since  2020年3月17日
 */
@Slf4j
@RestControllerAdvice
//@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(SampleException.class)
	public HttpEntity<Response> handleException(SampleException e) {
		log.error(e.getErrorCode().getCode() + ": " + e.getMessage(), e);
		Response response = new Response();
		response.setMessage(e.getMessage());
		response.setErrorCode(e.getErrorCode());
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(AuthException.class)
	public HttpEntity<Response> handleAuthException(AuthException e) {
		log.error(e.getErrorCode().getCode() + ": " + e.getMessage(), e);
		return new ResponseEntity<Response>(new Response(e.getErrorCode(), e.getMessage()), HttpStatus.UNAUTHORIZED);
	}

}
