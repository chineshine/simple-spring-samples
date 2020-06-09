package c.s.sample.apply.entity;


import lombok.Data;

@Data
public class ApplicationForm implements ApplicationEntity{
	
	private Long id;
	
	/**
	 * 申请类型
	 */
	private ApplicationType applicationType;

	/**
	 * 申请名称
	 */
	private String name;
	
	/**
	 * 申请人
	 */
	private String applicant;
	
	/**
	 * 提交者
	 */
	private String submitter;

	/**
	 * 申请描述
	 */
	private String description;
	
	private String status;
}
