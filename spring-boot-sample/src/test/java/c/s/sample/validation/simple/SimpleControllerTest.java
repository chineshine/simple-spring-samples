package c.s.sample.validation.simple;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import c.s.sample.ControllerTestBase;
import lombok.extern.slf4j.Slf4j;

/**
 * @author chineshine
 * @since  2020年3月16日
 */
@Slf4j
public class SimpleControllerTest extends ControllerTestBase {

	private @Autowired TestRestTemplate testRestTemplate;

	@Test
	public void demo1Test() {
		SimpleVo vo = new SimpleVo();
		vo.setName("simple");
		vo.setAge(12);
		RequestEntity<SimpleVo> requestEntity = RequestEntity.post(URI.create("/valid/simple/1")).body(vo);
		ResponseEntity<String> responseEntity = testRestTemplate.exchange(requestEntity, String.class);
		String result = responseEntity.getBody();
		log.info("返回结果: " + result);
		assertEquals("success", result);
	}
}
