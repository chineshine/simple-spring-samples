package c.s.sample.openstack.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import c.s.sample.openstack.Data;
import c.s.sample.openstack.command.Executor;
import c.s.sample.openstack.constant.Constants;
import c.s.sample.openstack.ro.Resources;
import c.s.sample.openstack.service.ResourcesService;
import c.s.sample.openstack.validation.Validator;

/**
 * @author chineshine
 * @since  2020年6月30日
 */
public class ResourceServiceImpl implements ResourcesService {

	private @Autowired ApplicationContext applicationContext;

	private @Autowired Executor executor;

	@Override
	public Data doAction(Resources resourceData, String operation) {
		Boolean isValidated = this.validate(resourceData);
		if (isValidated) {
			return executor.execute(resourceData, operation);
		}

		throw new RuntimeException("验证失败...");
	}

	@Override
	public Boolean validate(Resources resourceData) {
		return resourceData.needToValidate() ? getValidator(resourceData.getResourceType()).validate(resourceData)
				: Boolean.TRUE;
	}

	private Validator getValidator(String resourceType) {

		String beanName = resourceType + Constants.VALIDATOR;

		Validator validator = (Validator) applicationContext.getBean(beanName);

		if (validator == null) {
			throw new NullPointerException("未查找到指定的验证器, validator: " + validator);
		}

		return validator;

	}

}
