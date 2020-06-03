package c.s.sample.lang3;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

/**
 * @author chineshine
 * @since  2020年6月2日
 */
public class ThreadPool {

	ScheduledExecutorService create() {
		int corePoolSize = 5;
		ThreadFactory threadFactory = new BasicThreadFactory.Builder().namingPattern("cs-sample-pool-d%").daemon(true)
				.build();
		return new ScheduledThreadPoolExecutor(corePoolSize, threadFactory, new ThreadPoolExecutor.AbortPolicy());
	}
}
