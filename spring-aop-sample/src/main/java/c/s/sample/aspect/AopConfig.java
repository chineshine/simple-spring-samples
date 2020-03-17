package c.s.sample.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import c.s.sample.AopException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author chineshine
 * @since  2020年3月17日
 */
@Slf4j
@Aspect
public class AopConfig {
	/**
	    注解说明:
		{@link Aspect}: <code>@Aspect</code> 类注解,定义该类为切面类
		{@link Pointcut}: <code>@Pointcut</code> 方法注解,定义切点
		{@link Before}: <code>@Pointcut</code> 方法注解,切点开始前切入内容
		{@link After}: <code>@After</code> 方法注解,切点结尾切入内容
		{@link AfterReturning}: <code>@AfterReturning</code> 方法注解,切点返回后,切入内容,可以处理返回值
		{@link Around}: <code>@Around</code> 方法注解,在切点前后切入内容,并控制何时执行切点内容
		{@link AfterThrowing}: <code>@AfterThrowing</code> 方法注解,在切点抛出异常后切入内容
		
		{@link Order} <code>@Order</code> 定义执行顺序
	
	*/

	@Pointcut
	public void exceptionPoint() {
	}

	@AfterThrowing
	public void doAfterThrowing(AopException ex) {
		log.error(ex.getMessage(), ex);
	}

}
