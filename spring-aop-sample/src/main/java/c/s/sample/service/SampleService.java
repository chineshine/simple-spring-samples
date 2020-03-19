package c.s.sample.service;

import org.springframework.stereotype.Service;

import c.s.sample.exception.ErrorCode;
import c.s.sample.exception.SampleException;

/**
 * @author chineshine
 * @since  2020年3月18日
 */
@Service
public class SampleService {

	public void doService() {
		throw new SampleException(ErrorCode.requestInternalError,"测试在service层报错是不是被 controller advice 捕捉");
	}

	
}
