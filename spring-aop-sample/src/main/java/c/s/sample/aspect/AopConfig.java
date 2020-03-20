package c.s.sample.aspect;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author chineshine
 * @since  2020年3月17日
 */
@SuppressWarnings("unused")
@Slf4j
@Aspect
@Component
public class AopConfig {
	/**
	    注解说明:
		{@link Aspect @Aspect}:  类注解,定义该类为切面类
		{@link Pointcut @Pointcut}:  方法注解,定义切点
		{@link Before @Before}:  方法注解,切点开始前切入内容
		{@link After @After}:  方法注解,切点结尾切入内容
		{@link AfterReturning @AfterReturning}:  方法注解,切点返回后,切入内容,可以处理返回值
		{@link Around @Around}:  方法注解,在切点前后切入内容,并控制何时执行切点内容
		{@link AfterThrowing @AfterThrowing}:  方法注解,在切点抛出异常后切入内容
		
		{@link Order} <code>@Order</code> 定义执行顺序
		
	    执行顺序:
	    around -> before -> after -> (没报错)afterReturning / (报错)afterThrowing 
	         建议 around 不要和 before&after 连用
	
	*/

	/**
		execution解释:
		  execution(<修饰符模式>?<返回类型模式><方法名模式>(<参数模式>)<异常模式>?)
		本例说明: execution(* c.s.sample.controller..*.*(..)
		* 表示修饰符,也可以是: public, private, protected, *
		c.s.sample.controller 表示包名
		.. 表示当前包和子包
		*.* 表示所有类名+所有方法
		(..) 表示参数模式
	 */
	@Pointcut("execution(* c.s.sample.controller..*.*(..))")
	public void requestCostPointcut() {
	}

//	@Around("requestCostPointcut()")
	public Object aroundRequest(ProceedingJoinPoint proceedingJoinPoint ) throws Throwable {
		log.info("执行到: around");
		
		return proceedingJoinPoint.proceed();
		
		/**
			分布式锁实现:
			  1. 从内存中(如使用 redis),获取被 @Lock 注解的方法的名称是否存在,判断是否已锁定
			  2. 没锁,则锁定并让 @Lock 注解的方法执行
			  3. 锁定,则给前端提示: "勿频繁操作",
			  4. 方法执行完毕后,调用解锁方法,将其解锁
			  5. 如果锁超时,则自动解锁
		 */
	}
	
	private static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<>();

	@Before("requestCostPointcut()")
	public void beforeRequest(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		Long start = System.currentTimeMillis();
		String declaringTypeName = signature.getDeclaringTypeName();
		String methodName = signature.getName();

		log.info("请求: " + declaringTypeName + "." + methodName + " 开始执行");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("declaringTypeName", declaringTypeName);
		map.put("methodName", methodName);
		threadLocal.set(map);
	}

	@After("requestCostPointcut()")
	public void afterRequest() {
		Map<String, Object> map = threadLocal.get();
		Long end = System.currentTimeMillis();
		Long start = (Long) map.get("start");
		Long cost = end - start;

		String declaringTypeName = (String) map.get("declaringTypeName");
		String methodName = (String) map.get("methodName");

		log.info("请求: " + declaringTypeName + "." + methodName + " 执行结束, 请求耗时: " + cost);

		threadLocal.remove();
	}

	@AfterReturning(value = "requestCostPointcut()", returning = "response")
	public void afterRequestReturning(Object response) {
		log.info("执行到: afterReturning");
	}

	@AfterThrowing(pointcut = "requestCostPointcut()", throwing = "ex")
	public void doAfterThrowing(Exception ex) {
		log.info("执行到: afterThrowing");
	}

}
