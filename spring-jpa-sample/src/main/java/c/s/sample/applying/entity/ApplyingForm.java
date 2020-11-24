package c.s.sample.applying.entity;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class ApplyingForm {
	
	private ApplyingType applyingType;

	private String ApplyingName;
	
	private String processingStatus;
}
