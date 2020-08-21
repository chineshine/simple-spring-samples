package c.s.sample.modules.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import c.s.sample.config.log.annotation.Log;
import c.s.sample.config.log.annotation.Logger;
import lombok.extern.slf4j.Slf4j;

/**
 * @author chineshine
 * @since  2020年8月19日
 */
@Slf4j
@Logger(resource = "user",persist = true)
@RestController
@RequestMapping("/user")
public class UserController {

	@Log(action = "create")
	@GetMapping("/create")
	public void create() {
		log.info("this is the create action of user");
	}
}
