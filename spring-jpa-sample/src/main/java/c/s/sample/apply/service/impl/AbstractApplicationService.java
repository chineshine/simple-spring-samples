package c.s.sample.apply.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import c.s.sample.apply.entity.ApplicationEntity;
import c.s.sample.apply.service.ApplicationService;
import c.s.sample.apply.vo.ApplicationBlank;

/**
 * @author chineshine
 * @since  2020年5月26日
 */
public abstract class AbstractApplicationService implements ApplicationService {

	@Autowired
	private ApplicationFormService applicationFormService;

	@Override
	public ApplicationEntity saveData(ApplicationBlank blank) {
		return applicationFormService.saveData(blank);
	}

}
