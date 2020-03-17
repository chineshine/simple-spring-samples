package c.s.sample.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import c.s.sample.ControllerTestBase;
import lombok.extern.slf4j.Slf4j;

/**
 * @author chineshine
 * @since  2020年3月17日
 */
@Slf4j
public class SampleControllerTest extends ControllerTestBase {

	private @Autowired TestRestTemplate testRestTemplate;

	@Test
	public void doGetTest() {
		String uri = "/doget?name={name}";
		HttpEntity<?> requestEntity = new HttpEntity<>(null);
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("name", "1");
		ResponseEntity<String> responseEntity = testRestTemplate.exchange(uri, HttpMethod.GET, requestEntity,
				String.class, variables);
		log.info(responseEntity.getBody());
		log.info(responseEntity.getStatusCode() + "");
		assertNotEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

}
