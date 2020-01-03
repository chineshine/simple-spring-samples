package c.s.sample.modules.dog.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chineshine
 * @date 2020年1月3日
 *
 */
@RestController
@RequestMapping("/dog")
public class DogController {

	@GetMapping
	public String getDog() {
		return "this is a dog";
	}

	@GetMapping("/name")
	public String getDogName() {
		return "wangwang";
	}

	@GetMapping("/kind")
	public String getDogKind() {
		return "hashiqi";
	}
	
	@DeleteMapping
	public String deleteDog() {
		return "this dog has been selt";
	}
}
