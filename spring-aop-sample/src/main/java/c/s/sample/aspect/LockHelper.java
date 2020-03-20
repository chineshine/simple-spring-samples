package c.s.sample.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

/**
 * @author chineshine
 * @since  2020年3月20日
 */
public class LockHelper {

	/**
	 * 通过切点获取 注解 lock
	 * @param joinPoint
	 * @return
	 */
	public Lock getLockAnnotation(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		Class<?> type = signature.getDeclaringType();
		String methodName = signature.getName();
		try {
			Method method = type.getDeclaredMethod(methodName);

			// 加在私有方法上没用
			if (method.isAccessible()) {
				Lock lockAnnotation = method.getAnnotation(Lock.class);
				return lockAnnotation;
			}
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 上锁
	 */
	public void lock(Lock lock) {
		// 将锁的信息存储到 redis 当中
	}
	
	
	
	/**
	 * 判断是否已锁
	 * @return
	 */
	public void unlock(String name,String key) {
		// 1. 根据 name 和 key 从 redis 中获取锁的信息
	}
}
