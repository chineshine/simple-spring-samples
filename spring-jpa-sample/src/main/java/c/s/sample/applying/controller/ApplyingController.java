package c.s.sample.applying.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/applying")
public class ApplyingController {

	@PostMapping
	public String doApplying() {
		return null;
	}


}
