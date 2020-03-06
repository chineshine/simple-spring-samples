package c.s.sample.listener.third;

import org.springframework.context.ApplicationEvent;

import lombok.extern.slf4j.Slf4j;

/**
 * @author chineshine
 * @since  2020年3月5日
 */
// way.3
@Slf4j
public class ThirdEvent extends ApplicationEvent{
	private static final long serialVersionUID = -2179975881397337905L;

	public ThirdEvent(Object source) {
		super(source);
		log.info("第三个 event ...");
	}


}
