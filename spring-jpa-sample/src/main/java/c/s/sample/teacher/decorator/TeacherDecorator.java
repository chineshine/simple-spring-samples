package c.s.sample.teacher.decorator;

import c.s.sample.teacher.Teacher;
import c.s.sample.teacher.proxy.TeacherStaticProxy;
import lombok.extern.slf4j.Slf4j;

/**
 * @author chineshine
 * @since  2020年8月10日
 */
@Slf4j
public class TeacherDecorator implements Teacher {

	public Teacher teacher;

	public TeacherDecorator() {
		this.teacher = new TeacherStaticProxy();
	}

	public TeacherDecorator(Teacher teacher) {
		if (teacher != null) {
			this.teacher = teacher;
		} else {
			this.teacher = new TeacherStaticProxy();
		}
	}

	@Override
	public void teach() {
		log.info("let's begin");
		teacher.teach();
		log.info("the class is over");
	}

}
