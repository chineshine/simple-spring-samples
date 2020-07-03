package c.s.sample.openstack.constant;

/**
 * @author chineshine
 * @since  2020年6月29日
 */
public class Constants {

	public static final String COMMAND = "Command";
	public static final String VALIDATOR = "Validator";

	public static class Resource {
		public static final String VM = "Vm";
		
		private Resource() {
		}
	}

	public static class Operation {

		/*-----------通用操作-------------*/
		public static final String SYNC = "Sync";
		public static final String CREATE = "Create";
		public static final String UPDATE = "Update";
		public static final String DELETE = "Delete";
		public static final String SEARCH = "Search";
		
		
		private Operation() {
		}
	}

	private Constants() {
	}

}
