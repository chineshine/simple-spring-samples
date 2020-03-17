package c.s.sample;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author chineshine
 * @since  2020年3月16日
 */
/**
 * 指定配置文件: {@link ActiveProfiles} @ActiveProfiles(profiles = "test")
 * 
 * 如: test 指 application-test.yml ,可放在 src/main/test 目录下
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ControllerTestBase {

}
