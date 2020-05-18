package c.s.sample.apply.entity;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class ApplicationForm {
	
	private ApplicationType applicationType;

	private String name;
	
	/**
	 * 申请人
	 */
	private String applicant;
}
