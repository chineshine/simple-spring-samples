package c.s.sample.config;

import java.util.function.Supplier;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author chineshine
 * @since  2020年3月13日
 */
public class RabbitmqBeanDefinition implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		ImportBeanDefinitionRegistrar.super.registerBeanDefinitions(importingClassMetadata, registry);

		BeanDefinition queueDefinition = beanDefinition(Queue.class, queueSupplier("queue1"));
		registry.registerBeanDefinition("queue1", queueDefinition);

	}

	public <T> BeanDefinition beanDefinition(Class<T> beanClass, Supplier<T> supplier) {
		BeanDefinitionBuilder definitionBuilder = null;
		if (supplier == null) {
			definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(beanClass);
		} else {
			definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(beanClass, supplier);

		}
		return definitionBuilder.getBeanDefinition();
	}

	public Supplier<Queue> queueSupplier(String name) {
		Supplier<Queue> queueSupplier = new Supplier<Queue>() {
			@Override
			public Queue get() {
				return new Queue(name, false);
			}
		};
		return queueSupplier;
	}

	public Supplier<TopicExchange> exchangeSupplier(String name) {
		Supplier<TopicExchange> exchangeSupplier = new Supplier<TopicExchange>() {
			@Override
			public TopicExchange get() {
				return new TopicExchange(name);
			}
		};
		return exchangeSupplier;
	}
}
