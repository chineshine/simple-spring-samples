package c.s.sample.config;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author chineshine
 * @since  2020年6月3日
 */
@Configuration
public class BatchConfiguration extends DefaultBatchConfigurer{
	/**
	 * 自定义bacth 配置: 
	 *   实现 org.springframework.batch.core.configuration.annotation.BatchConfigurer 接口
	 *   或 继承 org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer
	 */
	
	private @Autowired DataSource dataSource;
	
	private @Autowired ThreadPoolTaskExecutor taskExecutor;
	
	@Override
	protected JobRepository createJobRepository() throws Exception {
		JobRepositoryFactoryBean factoryBean = new JobRepositoryFactoryBean();
//		factoryBean.setDatabaseType("mysql");
		// 数据库类型
		factoryBean.setDatabaseType("H2");
		//数据库
		factoryBean.setDataSource(dataSource);
		// 事务
		factoryBean.setTransactionManager(getTransactionManager());
		// 事务的隔离级别
//		factoryBean.setIsolationLevelForCreate("");
		// 数据库表名前缀
		factoryBean.setTablePrefix("batch_");
		factoryBean.afterPropertiesSet();
		return factoryBean.getObject();
	}
	
	@Override
	protected JobLauncher createJobLauncher() throws Exception {
		SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
		jobLauncher.setJobRepository(getJobRepository());
		jobLauncher.setTaskExecutor(taskExecutor);
		return jobLauncher;
	}
}
