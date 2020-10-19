/**
 * 
 */
package c.s.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author chineshine
 * @since 2020-8-27
 */
@RestController
public class RestSampleController {

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/user")
	public String user() {
		return "user";
	}
}
