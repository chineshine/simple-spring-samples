package c.s.sample.apply.vo;

import c.s.sample.apply.annotation.Application;
import c.s.sample.apply.entity.ApplicationType;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author chineshine
 * @since  2020年5月20日
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Application(applicationType = ApplicationType.VACATION)
public class VacationApply implements ApplicationBlank {
	
	private ApplicationType applicationType;
	
	private String description;

	private Long id;

	private Integer days;
	
	private String status;
	
	private String applicant;




}
