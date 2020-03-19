package c.s.sample.validation.customer;

import java.util.Collection;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.CollectionUtils;

/**
 * @author chineshine
 * @since  2020年3月19日
 */
public class ArrayNotNullValidator implements ConstraintValidator<ArrayNotNull, Collection<?>> {

	@Override
	public boolean isValid(Collection<?> value, ConstraintValidatorContext context) {

		return !CollectionUtils.isEmpty(value);
	}

}
