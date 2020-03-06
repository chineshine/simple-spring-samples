package c.s.sample.listener.second;

import org.springframework.context.ApplicationEvent;

import lombok.extern.slf4j.Slf4j;

/**
 * @author chineshine
 * @since  2020年3月5日
 */
@Slf4j
public class SecondEvent extends ApplicationEvent{
	private static final long serialVersionUID = 1472683754403900279L;

	
	public SecondEvent(Object source) {
		super(source);
		log.info("第二个 event ...");
	}


}
