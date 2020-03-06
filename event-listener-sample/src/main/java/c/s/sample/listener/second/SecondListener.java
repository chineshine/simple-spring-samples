package c.s.sample.listener.second;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author chineshine
 * @since  2020年3月5日
 */
// way.2
@Component
@Slf4j
public class SecondListener implements ApplicationListener<SecondEvent> {

	@Override
	public void onApplicationEvent(SecondEvent event) {
		log.info(event.getSource().toString());
		log.info("第二个listener,time:" + event.getTimestamp());
	}

	/**
		way.2 :
		  两种方式注册监听器
		 ① 使用注解: <code>@Component</code> 
		 ② 在配置文件 application.properties 在配置: 
			context.listener.classes=c.s.sample.listener.second.SecondListener
	 */
}
