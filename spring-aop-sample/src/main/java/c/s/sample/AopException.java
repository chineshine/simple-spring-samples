package c.s.sample;

import lombok.Getter;

/**
 * @author chineshine
 * @since  2020年3月17日
 */

public class AopException extends RuntimeException{
	private static final long serialVersionUID = 4726174347821437853L;

	@Getter
	private String code;

	public AopException(String code) {
		this.code = code;
	}

	public AopException(String code,String message) {
		super(message);
		this.code = code;
	}
	
	public AopException(String code,String message,Throwable cause) {
		super(message, cause);
		this.code = code;
	}
	
}
