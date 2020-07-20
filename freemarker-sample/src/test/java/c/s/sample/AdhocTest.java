package c.s.sample;

import org.junit.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class AdhocTest {

	@Test
	public void test1() throws ClassNotFoundException {
		Class.forName("java.lang.String");
	}

	@Test
	public void test2() {
		String aString = "ssh.ip";
		int index = aString.indexOf('.');
		System.out.println(aString.substring(0, index));
		System.out.println(aString.substring(index + 1));
	}

	/**
	 * 简单 json 测试
	 */
	@Test
	public void test3() {
		JsonArray jsonArray = new JsonArray();
		jsonArray.add("a");
		jsonArray.add(1);
		jsonArray.add(Boolean.TRUE);

		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("p", 1);
		jsonObj.addProperty("w", "s");

		jsonArray.add(jsonObj);

		System.out.println(jsonObj.toString());
		System.out.println(jsonArray.toString());
	}

	/**
	 * 重复覆盖测试
	 */
	@Test
	public void test4() {
		JsonObject user = new JsonObject();
		user.addProperty("username", "zhangsan");
		user.addProperty("sex", "male");
		System.out.println(user);

		JsonArray roles = new JsonArray();
		roles.add("admin");
		roles.add("user");
		user.add("roles", roles);
		System.out.println(roles);
		System.out.println(user);

		// 角色再添一个
		roles.add("project-manager");
		System.out.println(roles);
		System.out.println(user);

		// 重复加入角色
		// 验证: 下面代码重复
		user.add("roles", roles);
		System.out.println(user);

	}

	@Test
	public void test6() {
		JsonObject jsonObject = new JsonObject();
		System.out.println(jsonObject == null);

		// 验证: 为空不会报空指针
		JsonObject user = (JsonObject) jsonObject.get("user");
		System.out.println(user == null);
	}
}
