package c.s.sample.apply;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.method.support.HandlerMethodArgumentResolver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import c.s.sample.apply.vo.ApplicationBlank;
import lombok.extern.slf4j.Slf4j;

/*
 * @author chineshine
 * @since  2020年5月20日
 */
@Slf4j
@RestController
@RequestMapping("/application-form")
public class ApplyController {

	@PostMapping("/apply")
	public String apply(@RequestBody JsonNode json) {

		log.info("-------------");

		log.info(json.get("days").asText());
		String applicationType = json.get("applicationType").asText();
		Class<?> subclass = ApplicationBlank.getSubClassType(applicationType);
		ApplicationBlank apply = (ApplicationBlank) new ObjectMapper().convertValue(json, subclass);

		log.info(apply.toString());

		return "id";
	}

}
