package c.s.sample.apply.service.impl;

import org.springframework.stereotype.Service;

import c.s.sample.apply.annotation.Application;
import c.s.sample.apply.entity.ApplicationEntity;
import c.s.sample.apply.entity.ApplicationType;
import c.s.sample.apply.service.ApplicationService;
import c.s.sample.apply.vo.ApplicationBlank;
import c.s.sample.apply.vo.VacationApply;
import lombok.extern.slf4j.Slf4j;

/**
 * @author chineshine
 * @since  2020年5月21日
 */
@Slf4j
@Service
@Application(applicationType = ApplicationType.VACATION)
public class VacationApplyService extends AbstractApplicationService implements ApplicationService {

	@Override
	public void doApply(ApplicationBlank applicationBlank) {
		ApplicationEntity entity = saveData(applicationBlank);
		log.info(entity.getId() + "");
		VacationApply apply = (VacationApply) applicationBlank;

		log.info(apply.getDays() + "");
	}

}
