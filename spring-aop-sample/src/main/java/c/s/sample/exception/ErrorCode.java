package c.s.sample.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author chineshine
 * @since  2020年3月17日
 */
@NoArgsConstructor
@AllArgsConstructor
public enum ErrorCode {
	badRequest("http.request.bad_request"),

	requestInternalError("http.request.internal_error"),
	
	;

	@Getter
	private String code;
}
