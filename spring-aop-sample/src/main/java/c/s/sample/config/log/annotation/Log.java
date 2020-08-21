package c.s.sample.config.log.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @author chineshine
 * @since  2020年8月18日
 */
@Documented
@Retention(RUNTIME)
@Target(METHOD)
public @interface Log {
	
	/**
	 * 操作名称
	 */
	String action();
}
