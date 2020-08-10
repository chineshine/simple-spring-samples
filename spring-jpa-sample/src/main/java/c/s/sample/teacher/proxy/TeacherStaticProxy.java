package c.s.sample.teacher.proxy;

import c.s.sample.teacher.DefaultTeacher;
import c.s.sample.teacher.Teacher;
import lombok.extern.slf4j.Slf4j;

/**
 * @author chineshine
 * @since  2020年8月10日
 */
@Slf4j
public class TeacherStaticProxy implements Teacher {

	private Teacher teacher = new DefaultTeacher();

	@Override
	public void teach() {
		log.info("this is the teacher proxy");
		teacher.teach();
	}

}
