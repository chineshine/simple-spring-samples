package c.s.sample.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import c.s.sample.order.service.OrderService;

/**
 * @author chineshine
 * @since  2020年8月10日
 */
@RestController
@RequestMapping("/order")
public class OrderController {

	private @Autowired OrderService orderService;

	@GetMapping("/{action}")
	public void doAction(@PathVariable String action, Long id, String operator) {
		if("create".equals(action)) {
			orderService.create();
		}else if("update".equals(action)) {
			Assert.notNull(id, "id 不能为空");
			Assert.notNull(operator, "操作员不能为空");
			orderService.update(id, operator);
		}
	}
}
