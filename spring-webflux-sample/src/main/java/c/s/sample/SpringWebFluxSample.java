package c.s.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chineshine
 * @date 2020年1月3日
 *
 */
@SpringBootApplication
public class SpringWebFluxSample {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(SpringWebFluxSample.class);
		// 由于 pom.xml 引入了web包,默认运行环境仍然是 servlet,需要将其指定为 webflux 的运行环境 netty
		application.setWebApplicationType(WebApplicationType.REACTIVE);
		application.run(args);
	}
}
