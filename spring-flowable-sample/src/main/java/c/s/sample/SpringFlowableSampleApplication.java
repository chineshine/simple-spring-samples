package c.s.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chineshine
 * @since  2020年6月9日
 */
@SpringBootApplication(proxyBeanMethods = false)
public class SpringFlowableSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFlowableSampleApplication.class, args);
	}

}
