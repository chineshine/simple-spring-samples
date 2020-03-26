package c.s.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author chineshine
 * @since  2020年3月26日
 */
@EnableCaching
@SpringBootApplication
public class SpringCacheSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCacheSampleApplication.class, args);
	}
}
