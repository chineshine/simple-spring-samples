package c.s.cloud.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author chineshine
 * @date 2019年12月31日
 *
 */
@EnableEurekaClient
@SpringBootApplication
public class FeignServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignServerApplication.class, args);
	}
}
