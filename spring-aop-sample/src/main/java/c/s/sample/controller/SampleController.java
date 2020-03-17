package c.s.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import c.s.sample.exception.ErrorCode;
import c.s.sample.exception.SampleException;

/**
 * @author chineshine
 * @since  2020年3月17日
 */
@RestController
public class SampleController {

	@GetMapping("/doget")
	public String doGet(String name) {
		if ("1".equals(name)) {
			throw new SampleException(ErrorCode.requestInternalError, "就想在这个地方报个错");
		}
		return "success";
	}
}
