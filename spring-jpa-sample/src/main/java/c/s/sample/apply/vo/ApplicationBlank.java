package c.s.sample.apply.vo;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.reflections.Reflections;
import org.springframework.util.CollectionUtils;

import c.s.sample.apply.annotation.Application;
import c.s.sample.apply.entity.ApplicationType;

/**
 * @author chineshine
 * @since  2020年5月6日
 */
public interface ApplicationBlank {

	public ApplicationType getApplicationType();

	public Long getId();

	public String getDescription();
	
	public String getApplicant();
	
	public String getStatus();

	static Class<?> getSubClassType(String applicationType) {
		Reflections reflections = new Reflections("c.s.sample.apply.vo");
		Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(Application.class);
		if (CollectionUtils.isEmpty(annotatedClasses)) {
			return null;
		}
		List<Class<?>> clazzes = annotatedClasses.stream().filter(x -> {
			Application application = x.getAnnotation(Application.class);

			if (application.applicationType().name().equals(applicationType)
					&& ApplicationBlank.class.isAssignableFrom(x)) {
				return true;
			}
			return false;
		}).collect(Collectors.toList());
		return CollectionUtils.isEmpty(clazzes) ? null : clazzes.get(0);
	}

}
