package c.s.sample.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import c.s.sample.entity.Dict;

/**
 * @author chineshine
 * @since  2020年3月26日
 */
@Repository
public class DictRepositoryImpl implements IDictRepository {

	@Override
	public Dict getDictByNameNotCache(String name) {
		simulateSlowService();
		Dict dict = new Dict();
		dict.setName(name);
		return dict;
	}

	@Override
	@Cacheable("dict") // 将值缓存
	public Dict getDictByNameCache(String name) {
		simulateSlowService();
		Dict dict = new Dict();
		dict.setName(name);
		return dict;
	}
	
	private void simulateSlowService() {
		Long period = 3000l;
		try {
			Thread.sleep(period);
		} catch (InterruptedException e) {
			throw new IllegalStateException(e);
		}
	}

}
