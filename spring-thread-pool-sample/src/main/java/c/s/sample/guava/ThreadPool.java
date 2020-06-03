package c.s.sample.guava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * @author chineshine
 * @since  2020年6月2日
 */
public class ThreadPool {

	ExecutorService create() {
		ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("cs-sample-pool-d%").build();
		return new ThreadPoolExecutor(5, 10, 0, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>(1024),
				threadFactory, new ThreadPoolExecutor.AbortPolicy());
	}
}
