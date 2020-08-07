package c.s.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author chineshine
 * @date 2019年12月5日
 *
 */
@SpringBootApplication
public class ClientServerApplication {
	
	
	private @Autowired RestTemplateBuilder builder; 
	
	@Bean 
    public RestTemplate restTemplate() { 
        return builder.build(); 
    } 

	public static void main(String[] args) {
		SpringApplication.run(ClientServerApplication.class, args);
	}
}
