package c.s.sample.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * @author chineshine
 * @since  2020年6月15日
 */
@Slf4j
@RestController
public class SampleController {

	
	private @Autowired RabbitTemplate rabbitTemplate;
	
	@GetMapping("/test1")
	public String test1() {
		log.info("--------------test1-----------------");
		rabbitTemplate.convertAndSend("directExchange1","dex1.dq1","this is a message...");
		return "success";
	}
}
