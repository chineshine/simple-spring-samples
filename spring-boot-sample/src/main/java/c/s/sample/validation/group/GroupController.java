package c.s.sample.validation.group;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
public class GroupController {

	@PostMapping("/group/1")
	public String group1(@Validated(value = One.class)@RequestBody GroupVo vo,BindingResult result) {
		if(result.hasErrors()) {
			return result.getFieldError().getDefaultMessage();
		}
		return "success";
	}
}
