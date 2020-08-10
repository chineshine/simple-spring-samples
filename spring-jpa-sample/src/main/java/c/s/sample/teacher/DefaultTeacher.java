package c.s.sample.teacher;

import lombok.extern.slf4j.Slf4j;

/**
 * @author chineshine
 * @since  2020年8月10日
 */
@Slf4j
public class DefaultTeacher implements Teacher{

	@Override
	public void teach() {
		log.info("give you a lession");
	}
}
