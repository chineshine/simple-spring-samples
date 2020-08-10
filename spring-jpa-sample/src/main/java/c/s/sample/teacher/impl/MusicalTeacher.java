package c.s.sample.teacher.impl;

import c.s.sample.teacher.Teacher;
import lombok.extern.slf4j.Slf4j;

/**
 * @author chineshine
 * @since  2020年8月10日
 */
@Slf4j
public class MusicalTeacher implements Teacher{

	@Override
	public void teach() {
		log.info("this is the music teacher, it will give you a music lession");
	}

	
}
