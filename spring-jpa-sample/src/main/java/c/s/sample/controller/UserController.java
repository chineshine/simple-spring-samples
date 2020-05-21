package c.s.sample.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import c.s.sample.model.Users;
import c.s.sample.repository.UsersRepository;
import c.s.sample.repository.page.IPageRepository;

/**
 * @author chineshine
 * @since  2020年3月27日
 */
@RestController
@RequestMapping("/users")
public class UserController {

	private @Autowired UsersRepository usersRepository;

	private @Autowired IPageRepository pageRepository;

	/**
	 * 适合多表查询分页
	 * @param users
	 * @param pageable
	 * @return
	 */
	@GetMapping("/page")
	public Page<Users> page(Users users, Pageable pageable) {
		StringBuilder sql = new StringBuilder();
		Map<String, Object> criterias = new HashMap<String, Object>();
		sql.append("select * from users u where 1=1 ");
		if (StringUtils.hasText(users.getUsername())) {
			// 格式必须如下, 使用 =: 方式传参,jpa 本身已经对sql注入作了一层处理
			sql.append(" and u.username=:username ");
			criterias.put("username", users.getUsername());
		}
		return pageRepository.page(sql, criterias, Users.class, pageable);
	}

	/**
	 * 单表查询分页
	 *   示例: http://localhost:8080/users/page2?username=zhangsan&sort=id,desc&sort=username,asc
	 * @param users
	 * @param pageable
	 * @return
	 */
	@GetMapping("/page2")
	public Page<Users> page2(Users users, Pageable pageable) {
		Specification<Users> specification = (root, query, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
			if (StringUtils.hasText(users.getUsername())) {
				predicates.add(criteriaBuilder.like(root.get("username"), "%" + users.getUsername() + "%"));
			}
			return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
		};
		return usersRepository.findAll(specification, pageable);
	}

	@GetMapping
	public List<Users> users() {
		return usersRepository.findAll();
	}
}
