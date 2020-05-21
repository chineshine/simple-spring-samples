package c.s.sample.apply;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import c.s.sample.ControllerTestBase;
import c.s.sample.apply.entity.ApplicationType;
import c.s.sample.apply.vo.VacationApply;

/**
 * @author chineshine
 * @since  2020年5月20日
 */
public class ApplyControllerTest extends ControllerTestBase {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void test() {
		VacationApply apply = new VacationApply();
		apply.setApplicationType(ApplicationType.VACATION);
		apply.setDays(3);
		ResponseEntity<String> responseEntity = testRestTemplate.postForEntity(URI.create("/application-form/apply"),
				apply, String.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

}
