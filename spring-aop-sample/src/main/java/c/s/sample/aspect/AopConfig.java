package c.s.sample.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import lombok.extern.slf4j.Slf4j;

/**
 * @author chineshine
 * @since  2020年3月17日
 */
@SuppressWarnings("unused")
@Slf4j
//@Aspect
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
//	@Pointcut("execution(* c.s.sample.controller..*.*(..))")
	public void exceptionPoint() {
	}

//	@AfterThrowing(pointcut = "exceptionPoint()",throwing = "ex")
	public void doAfterThrowing(Exception ex) {
		log.error(ex.getMessage(), ex);
	}

}
