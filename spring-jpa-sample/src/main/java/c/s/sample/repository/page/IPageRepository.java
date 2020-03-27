package c.s.sample.repository.page;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Order;

/**
 * @author chineshine
 * @since  2020年3月26日
 */
public interface IPageRepository {

	/**
	 * @param sql
	 * @param criterias
	 * @param returnClass
	 * @param pageable
	 * @return
	 */
	<T> Page<T> page(StringBuilder sql, Map<String, Object> criterias, Class<T> returnClass, Pageable pageable);

	/**
	 * @param pageable
	 * @return
	 */
	List<Order> getOrders(Pageable pageable);

}
