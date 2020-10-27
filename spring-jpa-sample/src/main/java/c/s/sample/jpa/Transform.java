package c.s.sample.jpa;

import org.springframework.beans.BeanUtils;

public interface Transform<VO extends Transform<VO>> {

	default <T> VO transfer(T t, VO vo) {
		BeanUtils.copyProperties(t, vo);
		return vo;
	}

	default <T> T transfer(VO vo, T t) {
		BeanUtils.copyProperties(vo, t);
		return t;
	}
}
