package c.s.sample.openstack.command.vm;

import org.springframework.stereotype.Service;

import c.s.sample.openstack.command.VmCommand;
import c.s.sample.openstack.constant.Constants;
import c.s.sample.openstack.ro.Resources;

/**
 * @author chineshine
 * @since  2020年6月23日
 */
@SuppressWarnings("unchecked")
@Service(Constants.Resource.VM + Constants.Operation.CREATE + Constants.COMMAND)
public class VmCreateCommand implements VmCommand {

	@Override
	public Void execute(Resources resources) {
		System.out.println("执行创建 vm");
		return null;
	}

}
