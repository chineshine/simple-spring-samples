package c.s.sample.listener.first;

import org.springframework.context.ApplicationEvent;

import lombok.extern.slf4j.Slf4j;

/**
 * @author chineshine
 * @since  2020年3月5日
 */
@Slf4j
public class FirstEvent extends ApplicationEvent{
	private static final long serialVersionUID = -2179975881397337905L;

	public FirstEvent(Object source) {
		super(source);
		log.info("第一个 event ...");
	}


}
