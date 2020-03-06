package c.s.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import c.s.sample.listener.first.FirstEvent;
import c.s.sample.listener.first.FirstListener;
import c.s.sample.listener.second.SecondEvent;
import c.s.sample.listener.third.ThirdEvent;

/**
 * @author chineshine
 * @since  2020年3月5日
 */
@SpringBootApplication
public class SpringEventListenerSampleApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication
				.run(SpringEventListenerSampleApplication.class, args);

		// way.1
		applicationContext.addApplicationListener(new FirstListener());
		applicationContext.publishEvent(new FirstEvent("第一个事件..."));

		// way.2
		applicationContext.publishEvent(new SecondEvent("第二个事件..."));

		// way.3
		applicationContext.publishEvent(new ThirdEvent("第三个事件..."));
		
	}
}
