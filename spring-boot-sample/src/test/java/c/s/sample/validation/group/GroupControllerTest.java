package c.s.sample.validation.group;

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
public class GroupControllerTest extends ControllerTestBase{

	private @Autowired TestRestTemplate testRestTemplate;

	@Test
	public void group1Test() {
		GroupVo group1 = new GroupVo();
		group1.setName("zhangsan");
//		group1.setAge(20);
		group1.setAge(35);
		RequestEntity<GroupVo> requestEntity = RequestEntity.post(URI.create("/valid/group/1")).body(group1);
		ResponseEntity<String> responseEntity = testRestTemplate.exchange(requestEntity, String.class);
		String result = responseEntity.getBody();
		log.info("返回结果: " + result);
		assertEquals("success", result);
	}
}
