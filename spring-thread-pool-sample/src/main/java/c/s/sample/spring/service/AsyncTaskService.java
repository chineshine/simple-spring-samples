package c.s.sample.spring.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author chineshine
 * @since  2020年6月2日
 */
@Slf4j
@Service
public class AsyncTaskService {

	@Async
	public void doIt(int num) {
		log.info(Thread.currentThread().getName() + "----" + num);
	}
	
	@Async("poolTaskExecutor1")
	public void doIt2(int num) {
		log.info(Thread.currentThread().getName() + "----" + num);
	}
}
