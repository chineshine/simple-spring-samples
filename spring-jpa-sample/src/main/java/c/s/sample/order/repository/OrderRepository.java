package c.s.sample.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import c.s.sample.order.entity.Order;

/**
 * @author chineshine
 * @since  2020年8月10日
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
