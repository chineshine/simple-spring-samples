package c.s.sample.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author chineshine
 * @since  2020年6月12日
 */
@RestController
public class SampleController {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@GetMapping("/s1")
	public String sample1() {
		// 只要连上 rabbitmq 服务器, rabbitmq 服务器是有这个交换机(exchange),就可以发送
		rabbitTemplate.convertAndSend("topicExchange1", "foo.bar.crazy","hahahaha");
		
		return "success";
	}
}
