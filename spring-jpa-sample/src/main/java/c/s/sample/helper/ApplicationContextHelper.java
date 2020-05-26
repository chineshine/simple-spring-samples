package c.s.sample.helper;

import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.Map.Entry;

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

	public <S extends T, T> T getBean(Class<T> clazz, Class<? extends Annotation> annotationType) {
		Map<String, T> map = applicationContext.getBeansOfType(clazz);
		for (Entry<String, T> entry : map.entrySet()) {
			applicationContext.findAnnotationOnBean(entry.getKey(), annotationType);
		}
		map.entrySet().forEach(es -> {
			if (applicationContext.findAnnotationOnBean(es.getKey(), annotationType) != null) {

			}
		});
		return null;
	}

	public <T> Map<String, T> getBeans(Class<T> clazz) {
		return applicationContext.getBeansOfType(clazz);
	}

}
