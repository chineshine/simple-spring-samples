package c.s.sample.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chineshine
 * @since  2020年6月15日
 */
@Configuration
public class RabbitmqConfiguration {

	@Bean("directQueue1")
	Queue directQueue1() {
		return QueueBuilder.durable("directName1").build();
	}

	@Bean("directExchange1")
	DirectExchange directExchange1() {
		return ExchangeBuilder.directExchange("directExchange1").build();
	}

	@Bean("directBinding1")
	Binding directBinding1(@Qualifier("directQueue1")Queue queue,  @Qualifier("directExchange1")DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("dex1.dq1");
	}
	
	
	@Bean("topicQueue1")
	Queue topicQueue1() {
		return new Queue("topicName1", false);
	}

	@Bean("topicExchange1")
	TopicExchange topicExchange1() {
		return new TopicExchange("topicExchange1");
	}

	@Bean("topicBinding1")
	Binding topicBinding1(@Qualifier("topicQueue1") Queue queue, @Qualifier("topicExchange1") TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
	}
}
