package c.s.cloud.sample.feign.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author chineshine
 * @date 2019年12月31日
 *
 */
@FeignClient("feign-server") // 此处填写服务名称
public interface FeignRemoteClient {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	String hello();
}
