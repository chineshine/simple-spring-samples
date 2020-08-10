package c.s.sample.teacher;

import org.junit.Test;

import c.s.sample.teacher.decorator.TeacherDecorator;
import c.s.sample.teacher.impl.MathTeacher;
import c.s.sample.teacher.proxy.TeacherStaticProxy;

/**
 * @author chineshine
 * @since  2020年8月10日
 */

public class TeacherTest {

	@Test
	public void decoratorTest() {
		Teacher math = new MathTeacher();
		Teacher teacher = new TeacherDecorator(math);
		teacher.teach();
		
		TeacherDecorator decorator = new TeacherDecorator();
		decorator.teach();
	}

	@Test
	public void staticProxyTest() {
		Teacher teacher = new TeacherStaticProxy();
		teacher.teach();
	}
}
