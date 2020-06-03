package c.s.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import c.s.sample.spring.service.AsyncTaskService;

/**
 * @author chineshine
 * @since  2020年6月2日
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AsyncTaskTest {

	@Autowired
	private AsyncTaskService asyncTaskService;

	@Test
	public void syncTest1() {
		for (int i = 0; i < 77; i++) {
			asyncTaskService.doIt(i);
		}
	}
	
	@Test
	public void test2() {
		for (int i = 0; i < 77; i++) {
			asyncTaskService.doIt2(i);
		}
	}
}
