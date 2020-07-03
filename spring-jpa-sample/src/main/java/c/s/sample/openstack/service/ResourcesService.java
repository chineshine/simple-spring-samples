package c.s.sample.openstack.service;

import c.s.sample.openstack.Data;
import c.s.sample.openstack.ro.Resources;

/**
 * @author chineshine
 * @since  2020年6月23日
 */
public interface ResourcesService {

	Data doAction(Resources resourceData,String operation);
	
	Boolean validate(Resources resourceData);

}
