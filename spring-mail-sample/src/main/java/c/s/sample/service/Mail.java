package c.s.sample.service;

import lombok.Data;

/**
 * @author chineshine
 * @since  2020年3月6日
 */
@Data
public class Mail {

	private String subject;
	
	private String[] to;
	
	private String content;
}
