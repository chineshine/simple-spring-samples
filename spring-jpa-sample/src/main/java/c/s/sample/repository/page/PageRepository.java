package c.s.sample.repository.page;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author chineshine
 * @since  2020年3月26日
 */
@Slf4j
@Repository
public class PageRepository implements IPageRepository {

	private final String COUNT_SQL_SENTENCE = " SELECT COUNT(pf1_.*) FROM (%s) pf1_ ";

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@SuppressWarnings("unchecked")
	public <T> Page<T> page(StringBuilder sql, Map<String, Object> criterias, Class<T> returnClass, Pageable pageable) {
		TypedQuery<T> query = (TypedQuery<T>) entityManager.createNativeQuery(sql.toString(), returnClass);
		setParametes(query, criterias);

		int firstResult = 0;
		if (pageable.hasPrevious()) {
			firstResult = (pageable.getPageNumber() - 1) * pageable.getPageSize();
		}
		query.setFirstResult(firstResult);
		query.setMaxResults(pageable.getPageSize());
		List<T> content = query.getResultList();
		Long count = this.count(sql, criterias);
		return new PageImpl<T>(content, pageable, count);
	}

	@Override
	public List<Order> getOrders(Pageable pageable) {
		Sort sort = pageable.getSort();
		if (sort.isEmpty()) {
			return null;
		}
		return sort.toList();
	}

	private Long count(StringBuilder sql, Map<String, Object> criterias) {
		String sqlString = String.format(COUNT_SQL_SENTENCE, sql.toString(), "%s");
		Query query = entityManager.createNativeQuery(sqlString);
		setParametes(query, criterias);
		return ((BigInteger) query.getSingleResult()).longValue();
	}

	private void setParametes(Query query, Map<String, Object> criterias) {
		if (criterias.isEmpty()) {
			log.info("条件查询的条件为空");
			return;
		}
		Set<Entry<String, Object>> criteriaSet = criterias.entrySet();
		for (Entry<String, Object> entry : criteriaSet) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
	}
}
