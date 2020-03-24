package c.s.sample.exception;

import com.fasterxml.jackson.annotation.JsonValue;

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
	
	requestNotFound("http.request.not_found"), 
	
	methodNotAllow("http.request.method_not_allow"),

	// ---------------------auth
	usernameNotExist("account.username.not_exist"), 
	
	passwordError("account.password.error")

	;

	@JsonValue
	@Getter
	private String code;

	public ErrorCode getByCode(String code) {
		for (ErrorCode errorCode : ErrorCode.values()) {
			if (code.equals(errorCode.getCode())) {
				return errorCode;
			}
		}
		throw new IllegalArgumentException("参数不合法: " + code);
	}
}
