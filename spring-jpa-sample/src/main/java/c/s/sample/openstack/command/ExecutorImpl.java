package c.s.sample.openstack.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import c.s.sample.openstack.constant.Constants;

/**
 * @author chineshine
 * @since  2020年6月24日
 */
public class ExecutorImpl implements Executor {

	@Autowired
	private ApplicationContext applicationContext;

	@Override
	public Command getCommand(String resourceType, String operation) {

		String beanName = resourceType + operation + Constants.COMMAND;

		Command command = (Command) applicationContext.getBean(beanName);

		if (command == null) {
			throw new NullPointerException("暂时查找到指定的命令, Command: " + command);
		}

		return command;
	}

}
