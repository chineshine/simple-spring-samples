package c.s.sample.config;

import javax.sql.DataSource;

import org.activiti.core.common.spring.identity.ExtendedInMemoryUserDetailsManager;
import org.activiti.engine.impl.cfg.StandaloneInMemProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author chineshine
 * @since  2020年6月9日
 */
@Configuration
public class ActivitiConfiguration {

	@Autowired
	DataSource dataSource;

	@Bean
	public StandaloneInMemProcessEngineConfiguration processEngineConfiguration() {
		StandaloneInMemProcessEngineConfiguration configuration = new StandaloneInMemProcessEngineConfiguration();
		configuration.setDatabaseType("H2");
		configuration.setDataSource(dataSource);
		return configuration;
	}

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetailsService detailsService = new ExtendedInMemoryUserDetailsManager();
		return detailsService;
	}
}
