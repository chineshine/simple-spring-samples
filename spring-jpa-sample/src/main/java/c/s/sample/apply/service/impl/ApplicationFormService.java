package c.s.sample.apply.service.impl;

import c.s.sample.apply.entity.ApplicationForm;
import c.s.sample.apply.service.ApplicationService;
import c.s.sample.apply.vo.ApplicationBlank;

/**
 * @author chineshine
 * @since  2020年5月25日
 */
public class ApplicationFormService implements ApplicationService{
	
	private ApplicationService getApplicationService() {
		return null;
	}

	@Override
	public void doApply(ApplicationBlank applicationBlank) {
		ApplicationForm form = new ApplicationForm();
		form.setApplicant(applicationBlank.getApplicant());
		form.setApplicationType(applicationBlank.getApplicationType());
		form.setDescription(applicationBlank.getDescription());
		// save(form)
	}

}
