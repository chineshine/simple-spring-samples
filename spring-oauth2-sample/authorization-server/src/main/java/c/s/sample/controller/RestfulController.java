package c.s.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chineshine
 * @date 2019年12月6日
 *
 */
@RestController
public class RestfulController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
}
