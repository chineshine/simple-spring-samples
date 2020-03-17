package c.s.sample.exception;

import lombok.Getter;

/**
 * @author chineshine
 * @since  2020年3月17日
 */
public class SampleException extends RuntimeException {

	private static final long serialVersionUID = -1572299389780771153L;

	@Getter
	private ErrorCode errorCode;

	public SampleException() {
		super();
	}

	public SampleException(ErrorCode errorCode) {
		super(errorCode.getCode());
		this.errorCode = errorCode;
	}

	public SampleException(ErrorCode errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public SampleException(ErrorCode errorCode, String message, Throwable throwable) {
		super(message, throwable);
		this.errorCode = errorCode;
	}

	public SampleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SampleException(String message, Throwable cause) {
		super(message, cause);
	}

	public SampleException(Throwable cause) {
		super(cause);
	}

}
