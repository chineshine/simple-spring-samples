package c.s.sample.validation.customer;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chineshine
 * @since  2020年3月19日
 */
@RestController
@RequestMapping("/valid")
public class CustomerController {

	@PostMapping("/customer/1")
	public String doPost(@Valid CustomerVo vo,BindingResult result) {
		if(result.hasErrors()) {
			return result.getFieldError().getDefaultMessage();
		}
		return "success";
	}
}
