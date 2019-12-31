package c.s.cloud.sample.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chineshine
 * @date 2019年12月31日
 *
 */
@RestController
public class SampleController {

	@Autowired
	DiscoveryClient client;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/hello")
	public String hello() {
		List<ServiceInstance> instances = client.getInstances("feign-server");
		ServiceInstance selectedInstance = instances.get(new Random().nextInt(instances.size()));
		return "Hello World: " + selectedInstance.getServiceId() + ":" + selectedInstance.getHost() + ":"
				+ selectedInstance.getPort();
	}

}
