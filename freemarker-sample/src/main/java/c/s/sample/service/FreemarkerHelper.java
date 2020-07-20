package c.s.sample.service;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import freemarker.core.TemplateElement;
import freemarker.ext.beans.StringModel;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

/**
 * @desc 此帮助类由于解析freemarker模板,获取变量,将模板覆盖值等
 * @author chineshine
 *
 */
@Service
@SuppressWarnings("deprecation")
public class FreemarkerHelper {

	/**
	 * @desc 此处两个变量为常量,仅限此类使用
	 */
	private String strings = "strings";
	private String obj = "obj";

	@Autowired
	private Configuration configuration;

	/**
	 * @desc 将模板中提取出的变量转为 jsonObject
	 * @param var
	 * @param parentObject
	 */
	public void variableToJsonObject(String var, JsonObject parentObject) {
		int index = var.indexOf('.');
		String entry = var.substring(0, index);
		String subEntry = var.substring(index + 1);

		JsonObject thisObject = (JsonObject) parentObject.get(entry);
		thisObject = thisObject != null ? thisObject : new JsonObject();
		if (hasSubObject(subEntry)) {
			JsonObject subObject = (JsonObject) thisObject.get(obj);
			subObject = subObject != null ? subObject : new JsonObject();
			this.variableToJsonObject(subEntry, subObject);
			thisObject.add(obj, subObject);
		} else {
			JsonArray array = (JsonArray) thisObject.get(strings);
			array = array != null ? array : new JsonArray();
			array.add(subEntry);
			thisObject.add(strings, array);
		}
		parentObject.add(entry, thisObject);
	}

	/**
	 * @desc 判断变量是否有子对象
	 * @param var 变量
	 * @return
	 */
	private Boolean hasSubObject(String var) {
		return var.indexOf('.') >= 0;
	}

	/**
	 * @desc 提取 freemarker 模板中变量
	 * @param uri 模板位置+名称
	 * @return
	 * @throws TemplateModelException
	 * @throws IOException
	 */
	public Set<String> referenceSet(String uri) throws TemplateModelException, IOException {
		Template template = configuration.getTemplate(uri);
		return this.referenceSet(template);
	}

	/**
	 * @desc 提取 freemarker 模板中变量
	 * @param template 模板
	 * @return
	 * @throws TemplateModelException
	 */
	public Set<String> referenceSet(Template template) throws TemplateModelException {
		Set<String> result = new HashSet<>();
		TemplateElement rootTreeNode = template.getRootTreeNode();
		for (int i = 0; i < rootTreeNode.getChildCount(); i++) {
			TemplateModel templateModel = rootTreeNode.getChildNodes().get(i);
			if (!(templateModel instanceof StringModel)) {
				continue;
			}
			Object wrappedObject = ((StringModel) templateModel).getWrappedObject();
			if (!"DollarVariable".equals(wrappedObject.getClass().getSimpleName())) {
				continue;
			}

			try {
				Object expression = getInternalState(wrappedObject, "expression");
				switch (expression.getClass().getSimpleName()) {
				case "Identifier":
					result.add(getInternalState(expression, "name").toString());
					break;
				case "DefaultToExpression":
					result.add(getInternalState(expression, "lho").toString());
					break;
				case "BuiltinVariable":
					break;
				case "Dot":
					result.add(expression.toString());
					break;
				default:
					throw new IllegalStateException("Unable to introspect variable");
				}
			} catch (NoSuchFieldException | IllegalAccessException e) {
				throw new TemplateModelException("Unable to reflect template model");
			}
		}
		return result;
	}

	private Object getInternalState(Object o, String fieldName) throws NoSuchFieldException, IllegalAccessException {
		Field field = o.getClass().getDeclaredField(fieldName);
		boolean wasAccessible = field.isAccessible();
		try {
			field.setAccessible(true);
			return field.get(o);
		} finally {
			field.setAccessible(wasAccessible);
		}
	}
}
