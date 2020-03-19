package c.s.sample.validation.customer;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import c.s.sample.ControllerTestBase;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomerControllerTest extends ControllerTestBase {

	private @Autowired TestRestTemplate testRestTemplate;

	@Test
	public void doPostTest() {
		CustomerVo vo = new CustomerVo();
		RequestEntity<CustomerVo> requestEntity = RequestEntity.post(URI.create("/valid/customer/1")).body(vo);
		ResponseEntity<String> responseEntity = testRestTemplate.exchange(requestEntity, String.class);
		String result = responseEntity.getBody();
		log.info("返回结果: " + result);
		assertEquals("success", result);
	}

}
