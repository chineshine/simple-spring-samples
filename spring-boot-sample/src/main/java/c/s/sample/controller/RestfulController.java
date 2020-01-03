package c.s.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chineshine
 * @date 2020年1月2日
 *
 */
@RestController
public class RestfulController {

	@GetMapping("/")
	public String index() {
		return "this is the index page";
	}
}
