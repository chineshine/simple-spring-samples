package c.s.sample.config.log.annotation;

import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author chineshine
 * @since  2020年8月18日
 */
@Documented
@Target(TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Logger {

	String resource();

	/**
	 * 是否持久化
	 */
	boolean persist() default false;

	/**
	 * 标准输出,输出到控制台
	 */
	boolean stdout() default true;
}
