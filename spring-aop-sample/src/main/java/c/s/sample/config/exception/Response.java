package c.s.sample.config.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

import c.s.sample.exception.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chineshine
 * @since  2020年3月18日
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {

	@JsonFormat(shape = JsonFormat.Shape.OBJECT)
	private ErrorCode errorCode;

	private String message;

	@Override
	public String toString() {
		return "{errorCode: " + errorCode.getCode() + "," + "message: " + message + "}";
	}

}
