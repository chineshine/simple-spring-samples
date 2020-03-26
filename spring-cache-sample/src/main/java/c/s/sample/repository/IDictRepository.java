package c.s.sample.repository;

import c.s.sample.entity.Dict;

/**
 * @author chineshine
 * @since  2020年3月26日
 */
public interface IDictRepository {

	Dict getDictByNameNotCache(String name);
	
	Dict getDictByNameCache(String name);
}
