package c.s.sample.apply.factory;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import c.s.sample.apply.annotation.Application;
import c.s.sample.apply.entity.ApplicationType;
import c.s.sample.apply.service.ApplicationService;
import c.s.sample.helper.ApplicationContextHelper;

/**
 * @author chineshine
 * @since  2020年5月6日
 */
@Component
public class ApplicationServiceFactory {

	@Autowired
	private ApplicationContextHelper getHelper;

	public ApplicationService get(ApplicationType appType) {
		Map<String, ? extends ApplicationService> map = getHelper.getBeans(ApplicationService.class);
		if (CollectionUtils.isEmpty(map)) {
			return null;
		}
		for (Entry<String, ? extends ApplicationService> entry : map.entrySet()) {
			Application app = entry.getValue().getClass().getAnnotation(Application.class);
			if(app == null) {
				continue;
			}
			if(appType.equals(app.applicationType())) {
				return entry.getValue();
			}
		}
		return null;
	}

}
