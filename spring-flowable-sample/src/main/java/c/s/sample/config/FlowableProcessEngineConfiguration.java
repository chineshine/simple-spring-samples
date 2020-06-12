package c.s.sample.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.flowable.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chineshine
 * @since  2020年6月10日
 */
@Configuration
public class FlowableProcessEngineConfiguration {

	private @Autowired DataSource dataSource;
	
	private @Autowired EntityManagerFactory entityManagerFactory;
	
	@Bean
	public SpringProcessEngineConfiguration processEngineConfiguration() {
		SpringProcessEngineConfiguration configuration = new SpringProcessEngineConfiguration();
		configuration.setDataSource(dataSource);
		configuration.setJpaEntityManagerFactory(entityManagerFactory);
		configuration.setDatabaseSchemaUpdate("true");
		configuration.setJpaHandleTransaction(true);
		configuration.setJpaCloseEntityManager(true);
		configuration.setAsyncExecutorActivate(false);
		return configuration;
	}
}
