package c.s.sample.modules.pig;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

/**
 * @author chineshine
 * @date 2020年1月3日
 *
 */
@RestController
@RequestMapping("/pig")
public class PigController {

	@GetMapping
	public String getPig() {
		return "this is a pig";
	}

	@GetMapping("/name")
	public Mono<String> getPigName() {
//		return we;
		return null;
	}
}
