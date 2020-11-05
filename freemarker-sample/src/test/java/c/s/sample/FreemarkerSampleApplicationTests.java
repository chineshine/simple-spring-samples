package c.s.sample;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import c.s.sample.entity.User;
import c.s.sample.service.FreemarkerService;

import org.apache.poi.POIDocument;
import org.apache.poi.extractor.POITextExtractor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ooxml.POIXMLDocument;
import org.apache.poi.ooxml.extractor.ExtractorFactory;
import org.apache.poi.ooxml.extractor.POIXMLTextExtractor;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.microsoft.ooxml.OOXMLParser;
import org.apache.tika.sax.BodyContentHandler;
import org.apache.xmlbeans.XmlException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import freemarker.template.TemplateException;
import freemarker.template.TemplateModelException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FreemarkerSampleApplicationTests {

	@Autowired
	private FreemarkerService freemarkerService;

	/**
	 1.  获取 .ftl 模板文件
	 2. 将 .ftl 文件解析并获取变量,方法已有 {@link FreemarkerService#referenceSet(freemarker.template.Template)}
	 3. 根据解析的变量通过 CMDB 去获取值
	 4.将变量的值注入到 模板中 {@link #test2()}
	 */

	@Test
	public void test2() throws IOException, TemplateException {
		JsonObject ssh = new JsonObject();
		Map<String, Object> map = new HashMap<>();
		ssh.addProperty("ip", "10.211.55.3");
		ssh.addProperty("user", "sin");
		map.put("ssh", ssh);
		JsonObject osAuth = new JsonObject();
		osAuth.addProperty("action", "start");
		osAuth.addProperty("os_auth_url", "http://172.16.120.251:5000/v3");
		osAuth.addProperty("os_auth_userName", "guan.xiaojue");
		osAuth.addProperty("os_auth_Password", "123456");
		osAuth.addProperty("os_auth_projectName", "wx_devops");
		osAuth.addProperty("os_auth_domainName", "devops");
		osAuth.addProperty("serverId", "2af0606d-c6de-48d9-89f3-2b538639dbd9");
		map.put("os_auth", osAuth);
		freemarkerService.writeToFile("e://a", map, "a.ftl");
	}

	/**
	 1. 获取模板解析并获取模板中所有变量
	 2. 递归解析子对象 
	 */
	@Test
	public void test3() throws TemplateModelException, IOException {
		Set<String> vars = freemarkerService.referenceSet("inventory.ftl");
		JsonObject json = new JsonObject();
		for (String var : vars) {
			System.out.println(var);
			this.variables(var, json);
		}
		System.out.println(json.toString());
	}

	public void variables(String var, JsonObject parentObject) {
		int index = var.indexOf('.');
		String entry = var.substring(0, index);
		String subEntry = var.substring(index + 1);

		JsonObject thisObject = (JsonObject) parentObject.get(entry);
		thisObject = thisObject != null ? thisObject : new JsonObject();
		if (hasSubObject(subEntry)) {
			JsonObject subObject = (JsonObject) thisObject.get("obj");
			subObject = subObject != null ? subObject : new JsonObject();
			this.variables(subEntry, subObject);
			thisObject.add("obj", subObject);
		} else {
			JsonArray array = (JsonArray) thisObject.get("strings");
			array = array != null ? array : new JsonArray();
			array.add(subEntry);
			thisObject.add("strings", array);
		}
		parentObject.add(entry, thisObject);

	}

	/**
	 1. 传递一个顶级对象名称:如 ssh
	 2. 根据这个顶级对象名称获取该对象所有的值,包括子对象的值
	 3. 关联对象的对应关系的规范定义
	 */
	
	public Boolean hasSubObject(String var) {
		return var.indexOf('.') >= 0;
	}

	
	
	@Test
	public void test4() throws IOException, TemplateException, OpenXML4JException, XmlException, SAXException, TikaException {
		List<User> users = Collections.nCopies(5, new User("zhangsan","male"));
		Map<String, Object> map = new HashMap<>();
		map.put("users", users);
//		freemarkerService.writeToFile("e://ss.xlsx", map, "example.xml");
		InputStream in = freemarkerService.writeToInputStream(map, "example.xml");
//		Parser parser = new xml
//				new OOXMLParser();
//		ContentHandler contentHandler = new BodyContentHandler(-1);
//		parser.parse(in, contentHandler, new Metadata(), new ParseContext());
//		System.out.println(contentHandler);
	}
	
	
}
