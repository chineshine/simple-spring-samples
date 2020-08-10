package c.s.sample.order.service;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c.s.sample.order.entity.Order;
import c.s.sample.order.repository.OrderRepository;

/**
 * @author chineshine
 * @since  2020年8月10日
 */
@Service
public class OrderService {

	private @Autowired OrderRepository orderRepository;
	
	@Transactional
	public Long create() {
		Order order = new Order();
		order.setOperator("zhangsan");
		order.setOrderNum(UUID.randomUUID().toString());
		orderRepository.save(order);
		return order.getId();
	}
	
	@Transactional
	public Long update(Long id,String operator) {
		Order order= orderRepository.findById(id).orElseThrow(()-> new NullPointerException("查找数据失败"));
		order.setOperator(operator);
		orderRepository.save(order);
		return id;
	}
}
