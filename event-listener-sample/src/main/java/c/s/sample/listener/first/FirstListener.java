package c.s.sample.listener.first;

import org.springframework.context.ApplicationListener;

import lombok.extern.slf4j.Slf4j;

/**
 * @author chineshine
 * @since  2020年3月5日
 */
@Slf4j
public class FirstListener implements ApplicationListener<FirstEvent> {

	@Override
	public void onApplicationEvent(FirstEvent event) {
		
		log.info(event.getSource().toString());
		log.info("第一个listener,time:" + event.getTimestamp());
	}

}
