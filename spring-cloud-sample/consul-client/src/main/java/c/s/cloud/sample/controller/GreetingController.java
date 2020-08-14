package c.s.cloud.sample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chineshine
 * @since  2020年8月14日
 */
@RestController
public class GreetingController {

	
	@RequestMapping("/hello")
	public String hello() {
		return "hello , this is the consul client sample";
	}
}
