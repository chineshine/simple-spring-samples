package c.s.sample.validation.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import c.s.sample.validation.service.service.DemoService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author chineshine
 * @since  2020年5月26日
 */
@Slf4j
@RestController
@RequestMapping("/service")
public class ServiceController {

	@Autowired
	private DemoService demoService;

	@GetMapping("/demo/1")
	public String demo1() {

		ServiceVo vo = new ServiceVo();
		try {
			demoService.validate1(vo);
		} catch (ConstraintViolationException e) {
			log.error(e.getMessage(), e);
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			violations.forEach(x -> {
				log.info(x.getMessage());
			});
		}
		return "validated";
	}

}
