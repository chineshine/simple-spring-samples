package c.s.sample.validation.simple;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * @author chineshine
 * @since  2020年3月16日
 */
@Data
public class SimpleVo {

	@NotNull(message = "{simple.name.notnull.message}")
	private String name;
	
	@Min(value = 20,message = "{simple.age.min.message}")
	private Integer age;
}
