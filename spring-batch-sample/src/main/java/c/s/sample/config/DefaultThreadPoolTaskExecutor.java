package c.s.sample.config;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import lombok.extern.slf4j.Slf4j;

/**
 * @author chineshine
 * @since  2020年6月3日
 */
@Slf4j
@EnableAsync
@Configuration
public class DefaultThreadPoolTaskExecutor implements AsyncConfigurer {

	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		// 核心线程数量
		executor.setCorePoolSize(15);
		// 最大线程数量
		executor.setMaxPoolSize(150);
		// 阻塞的任务队列大小
		executor.setQueueCapacity(500);
		// 线程存活时间
		executor.setKeepAliveSeconds(60);

		executor.setThreadNamePrefix("cs-sample-");

		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
		// 初始化线程池
		executor.initialize();
		return executor;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return new AsyncUncaughtExceptionHandler() {

			@Override
			public void handleUncaughtException(Throwable ex, Method method, Object... params) {
				log.error(ex.getMessage(), ex);
			}
		};
	}
	
}
