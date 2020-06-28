package c.s.sample.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Payload;

import lombok.extern.slf4j.Slf4j;

/**
 * @author chineshine
 * @since  2020年6月15日
 */
@Slf4j
@Configuration
public class RabbitListeners {

	/**
	 * 接收的监听器 ---- 方式2
	 * @param message
	 */
	@RabbitListener(queues = "directName1")
	public void listen1(@Payload String message) {
		log.info(new String(message));
	}
}
