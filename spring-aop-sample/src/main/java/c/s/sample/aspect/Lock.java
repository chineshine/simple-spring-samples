package c.s.sample.aspect;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * @author chineshine
 * @since  2020年3月20日
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Lock {

	String name();
	
	/**
	 * 持续时长,默认 7 秒
	 */
	long duration() default 7;
	
	/**
	 * 默认持续时长的单位: 秒
	 */
	TimeUnit timeUnit() default TimeUnit.SECONDS;
}
