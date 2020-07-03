package c.s.sample.openstack.command;

import c.s.sample.openstack.ro.Resources;

/**
 * @author chineshine
 * @since  2020年6月23日
 */
public interface Command {
	
	default <T> T execute(Resources resources) {
		throw new UnsupportedOperationException("暂不支持该操作");
	}

}
