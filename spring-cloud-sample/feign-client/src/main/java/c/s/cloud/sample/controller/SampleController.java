package c.s.cloud.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import c.s.cloud.sample.feign.remote.FeignRemoteClient;

/**
 * @author chineshine
 * @date 2019年12月31日
 *
 */
@RestController
public class SampleController {

	private @Autowired FeignRemoteClient feignRemoteClient; 
	
	@GetMapping("/")
	public String hello() {
		return feignRemoteClient.hello();
	}
}
