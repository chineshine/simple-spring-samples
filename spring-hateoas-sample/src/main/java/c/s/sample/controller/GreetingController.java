package c.s.sample.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.LinkRelation;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import c.s.sample.pojo.Greeting;

/**
 * @author chineshine
 * @since  2020年3月16日
 */
@RestController
public class GreetingController {

	private static final String TEMPLATE = "Hello, %s!";

	//超链接
	@RequestMapping("/greeting")
	public HttpEntity<Greeting> greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

		Greeting greeting = new Greeting(String.format(TEMPLATE, name));
//		greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());
		
		greeting.add(linkTo(methodOn(GreetingController.class).demo()).withRel(LinkRelation.of("demo")));

		return new ResponseEntity<>(greeting, HttpStatus.OK);
	}

	
	@GetMapping("/demo")
	public HttpEntity<String> demo() {
		// 必需 ResponseEntity 返回,否则无法创建 link
		return new ResponseEntity<String>("demo",HttpStatus.OK);
	}
}
