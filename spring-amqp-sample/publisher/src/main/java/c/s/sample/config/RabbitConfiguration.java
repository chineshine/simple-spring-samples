package c.s.sample.config;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;

//@Configuration
public class RabbitConfiguration {
	
	public @Bean SimpleRabbitListenerContainerFactory myFactory(ConnectionFactory connectionFactory,SimpleRabbitListenerContainerFactoryConfigurer configurer){
		SimpleRabbitListenerContainerFactory factory =
                new SimpleRabbitListenerContainerFactory();
//		factory.setMessageConverter(messageConverter);
		configurer.configure(factory, connectionFactory);
		return factory;
	} 
	
	SimpleMessageListenerContainer listenerContainer(ConnectionFactory connectionFactory,MessageListenerAdapter listenerAdapter ) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
	    container.setConnectionFactory(connectionFactory);
	    container.setQueueNames("");
	    container.setMessageListener(listenerAdapter);
	    return container;
	} 
}
