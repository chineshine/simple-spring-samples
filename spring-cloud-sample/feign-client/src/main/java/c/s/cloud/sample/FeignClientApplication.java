package c.s.cloud.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author chineshine
 * @date 2019年12月31日
 *
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class FeignClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignClientApplication.class, args);
	}
}
