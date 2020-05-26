package c.s.sample.validation.service.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import c.s.sample.validation.group.One;
import c.s.sample.validation.service.ServiceVo;

/**
 * @author chineshine
 * @since  2020年5月26日
 */
@Service
@Validated
public class DemoService {

	@Validated(One.class)
	public void validate1(@Valid ServiceVo vo) {
	}
}
