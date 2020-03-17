package c.s.sample.validation.group;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * @author chineshine
 * @since  2020年3月16日
 */
@Data
public class GroupVo {

	@NotNull(message = "{group.name.notnull.message}")
	private String name;

	@Max(value = 30,groups = One.class,message = "{group.one.age.max.message}")
	@Min(value = 70,groups = Two.class,message = "{group.two.age.min.message}")
	@Max(value = 80,groups = Two.class,message = "{group.two.age.max.message}")
	private Integer age;
}
