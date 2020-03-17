package c.s.sample.validation.simple;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chineshine
 * @since  2020年3月16日
 */
@RestController
@RequestMapping("/valid")
public class SimpleController {

	@PostMapping("/simple/1")
	public String demo1(@Valid @RequestBody SimpleVo vo, BindingResult result) {
		if (result.hasErrors()) {
			return result.getFieldError().getDefaultMessage();
		}
		return "success";
	}

}
