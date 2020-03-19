package c.s.sample.validation.customer;

import java.util.List;

import lombok.Data;

/**
 * @author chineshine
 * @since  2020年3月19日
 */
@Data
public class CustomerVo {

	@ArrayNotNull
	private List<String> strs;
} 
