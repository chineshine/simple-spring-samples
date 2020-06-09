package c.s.sample.helper;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author chineshine
 * @since  2020年5月25日
 */
@Component
public class ApplicationContextHelper implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	/**
	 * 获取某个类在 spring 容器中的所有子类或实现类
	 * @param clazz
	 * @return
	 */
	public <T> Map<String, T> getBeans(Class<T> clazz) {
		return applicationContext.getBeansOfType(clazz);
	}

}
