package c.s.sample.validation.service;

import javax.validation.constraints.NotNull;

import c.s.sample.validation.group.One;
import lombok.Data;

/**
 * @author chineshine
 * @since  2020年5月26日
 */
@Data
public class ServiceVo {

	@NotNull(groups = One.class)
	private String name;
}
