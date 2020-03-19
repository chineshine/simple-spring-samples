package c.s.sample.validation.customer;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Validate that the array is not null
 * @author chineshine
 * @since  2020年3月19日
 */
@Documented
@Constraint(validatedBy = { ArrayNotNullValidator.class })// 此处声明由哪个类校验
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ArrayNotNull {

	String message() default "{org.hibernate.validator.constraints.ArrayNotNull.message}";

	Class<?>[] groups() default {};

	// 不加此处,实体类传参验证会报错
	Class<? extends Payload>[] payload() default {};
}
