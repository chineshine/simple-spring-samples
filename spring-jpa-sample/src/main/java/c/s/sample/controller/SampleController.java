package c.s.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chineshine
 * @date 2019年12月25日
 *
 */
@RestController
public class SampleController {

	@GetMapping("/")
	public String index() {
		return "You are in index page !";
	}

}
