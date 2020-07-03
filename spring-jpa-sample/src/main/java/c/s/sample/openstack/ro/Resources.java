package c.s.sample.openstack.ro;

import c.s.sample.openstack.Data;

/**
 * @author chineshine
 * @since  2020年6月24日
 */
public interface Resources extends Data{
	
	String getResourceType();
	
	default Boolean needToValidate() {
		return Boolean.FALSE;
	}
}
