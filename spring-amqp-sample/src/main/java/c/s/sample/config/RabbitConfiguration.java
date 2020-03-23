package c.s.sample.config;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;

//@Configuration
public class RabbitConfiguration {
	
	private @Autowired ConnectionFactory connectionFactory;

	public @Bean SimpleRabbitListenerContainerFactory myFactory(SimpleRabbitListenerContainerFactoryConfigurer configurer){
		SimpleRabbitListenerContainerFactory factory =
                new SimpleRabbitListenerContainerFactory();
		configurer.configure(factory, connectionFactory);
//		factory.setMessageConverter(messageConverter);
		return factory;
	} 
}
