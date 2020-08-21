package c.s.sample.config.log.aspect;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import c.s.sample.config.log.annotation.Log;
import c.s.sample.config.log.annotation.Logger;
import c.s.sample.exception.SampleException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author chineshine
 * @since  2020年8月19日
 */
@Slf4j
@Aspect
@Component
public class LoggerAspect implements Ordered {
	private final String LOG_ACTION_FAILURE = "failure";
	private final String LOG_ACTION_SUCCESS = "success";

	@Override
	public int getOrder() {
		return 0;
	}

	@Pointcut("@target(c.s.sample.config.log.annotation.Logger)")
	public void loggerPointCut() {

	}

	@Pointcut("@annotation(c.s.sample.config.log.annotation.Log)")
	public void logPointCut() {
	}

	@Pointcut("loggerPointCut() && logPointCut()")
	public void logPoint() {
	}

	@AfterReturning(value = "logPoint()", returning = "response")
	public void afterReturning(JoinPoint joinPoint, Object response) {
		log.info(".......");
		solveLogger(joinPoint, new LogData(LOG_ACTION_SUCCESS));
	}

	@AfterThrowing(value = "logPoint()", throwing = "ex")
	public void afterThrowing(JoinPoint joinPoint, Exception ex) {
		LogData logData = new LogData(LOG_ACTION_FAILURE);
		if (ex instanceof SampleException) {
			String errorCode = ((SampleException) ex).getErrorCode().getCode();
			logData.setErrorCode(errorCode);
		}
		logData.setException(ex.getClass().getCanonicalName());
		logData.setErrorMsg(ex.getMessage());

		solveLogger(joinPoint, new LogData(LOG_ACTION_FAILURE));
	}

	private void solveLogger(JoinPoint joinPoint, LogData logData) {
		Signature signature = joinPoint.getSignature();
		Class<?> type = signature.getDeclaringType();
		String methodName = signature.getName();
		try {
			Method method = type.getDeclaredMethod(methodName);
			Log lg = method.getAnnotation(Log.class);
			lg.action();
			Logger logger = type.getAnnotation(Logger.class);
			if (logger.stdout()) {
				log.info("执行资源(" + logger.resource() + ")的(" + lg.action() + ")操作,结果: " + logData.getResult());
			}

			if (logger.persist()) {
				this.persistLog(logData);
			}
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}

	private void persistLog(LogData data) {
		// 此处应使用异步线程池的方式持久化日志
		log.info("日志被持久化了...");
	}

	@Data
	static class LogData {
		private String resource;

		private String action;

		private String exception;

		private String errorCode;

		private String errorMsg;

		private LocalDateTime occurTime;

		private String result;

		public LogData() {
		}

		public LogData(String result) {
			this.result = result;
		}
	}

}
