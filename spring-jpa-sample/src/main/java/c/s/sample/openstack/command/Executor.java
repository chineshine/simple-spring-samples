package c.s.sample.openstack.command;

import c.s.sample.openstack.ro.Resources;

/**
 * @author chineshine
 * @since  2020年6月23日
 */
public interface Executor {

	default <T> T execute(Resources resources,String operation) {
		Command command = getCommand(resources.getResourceType(),operation);
		return command.execute(resources);
	}
	
	public Command getCommand(String resourceType,String operation);
}
