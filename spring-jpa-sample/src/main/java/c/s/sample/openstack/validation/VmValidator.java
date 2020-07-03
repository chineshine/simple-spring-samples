package c.s.sample.openstack.validation;

import org.springframework.stereotype.Service;

import c.s.sample.openstack.constant.Constants;
import c.s.sample.openstack.ro.Resources;

/**
 * @author chineshine
 * @since  2020年6月30日
 */
@Service(Constants.Resource.VM + Constants.VALIDATOR)
public class VmValidator implements Validator{

	@Override
	public Boolean validate(Resources resourceData) {
		return Validator.super.validate(resourceData);
	}
}
