package c.s.sample.spring;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import lombok.extern.slf4j.Slf4j;

/**
 * @author chineshine
 * @since  2020年6月2日
 */
@Slf4j
@Configuration
@EnableAsync
public class ThreadPool {

	@Bean("poolTaskExecutor1")
	public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		// 核心线程数量
		executor.setCorePoolSize(15);
		// 最大线程数量
		executor.setMaxPoolSize(150);
		// 阻塞的任务队列大小
		executor.setQueueCapacity(500);
		// 线程存活时间
		executor.setKeepAliveSeconds(60);

//		executor.setThreadNamePrefix("cs-sample-d%");
		executor.setThreadFactory(factory());

		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
		// 初始化线程池
		executor.initialize();
		return executor;
	}

	private ThreadFactory factory() {
		return new ThreadFactoryBuilder().setNameFormat("cs-sample-%d").build();
	}

	/**
	 * 使用方式: 
	 * <p>
	 *   1. @Autowire @Qualifier("poolTaskExecutor1") ThreadPoolTaskExecutor executor;
	 *   ...
	 *   	executor.execute(thread);    -- 不带返回值
	 *   或   executor.submit(thread);     -- 带返回值
	 *   ...
	 * </p>  
	 * <p>
	 *   2. spring-boot, 在 main 方法上加上注解: @EnableAsync
	 *     在需要处理的方法上加上注解 @Async("poolTaskExecutor1")
	 * </p>
	 */

	/**
	 * 自定义拒绝策略1
	 * @author chineshine
	 * @since  2020年6月3日
	 */
	public static class Reject implements RejectedExecutionHandler {

		@Override
		public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
			try {
				r.wait();
				BlockingQueue<Runnable> queue = executor.getQueue();
				if (!queue.add(r)) {
					queue.put(r);
					r.notify();
				}
			} catch (InterruptedException e) {
				log.error(e.getMessage(), e);
				r.notify();
			}
		}
	}

	/**
	 * 拒绝策略2
	 * @author chineshine
	 * @since  2020年6月3日
	 */
	public static class Reject2 implements RejectedExecutionHandler {

		@Override
		public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
			BlockingQueue<Runnable> queue = executor.getQueue();
			try {
				queue.put(r);
			} catch (InterruptedException e) {
				log.error(e.getMessage(), e);
			}
		}

	}
}
