package c.s.sample.openstack.validation;

import c.s.sample.openstack.ro.Resources;

/**
 * @author chineshine
 * @since  2020年6月30日
 */
public interface Validator {

	default Boolean validate(Resources resourceData) {
		return Boolean.TRUE;
	}
}
