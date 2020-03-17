package c.s.sample.validation;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.util.CollectionUtils;

/**
 * @author chineshine
 * @since  2020年3月17日
 */
public interface IController {

	default <T> void validate(T t,Class<?>...groups ) {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<T>> violations = validator.validate(t,groups);
		if(CollectionUtils.isEmpty(violations)) {
			
		}else {
			List<String> msgs = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList()); 
			System.out.println(msgs);
		}
	}
}
