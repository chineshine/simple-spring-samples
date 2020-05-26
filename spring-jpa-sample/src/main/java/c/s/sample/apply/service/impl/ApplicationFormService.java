package c.s.sample.apply.service.impl;

import org.springframework.stereotype.Service;

import c.s.sample.apply.entity.ApplicationEntity;
import c.s.sample.apply.entity.ApplicationForm;
import c.s.sample.apply.service.ApplicationService;
import c.s.sample.apply.vo.ApplicationBlank;

/**
 * @author chineshine
 * @since  2020年5月25日
 */
@Service
public class ApplicationFormService implements ApplicationService{
	

	@Override
	public void doApply(ApplicationBlank applicationBlank) {
		
		// save(form)
	}

	@Override
	public ApplicationEntity saveData(ApplicationBlank blank) {
		ApplicationForm form = new ApplicationForm();
		form.setApplicant(blank.getApplicant());
		form.setApplicationType(blank.getApplicationType());
		form.setDescription(blank.getDescription());
		form.setId(1l);
		return form;
	}

}
