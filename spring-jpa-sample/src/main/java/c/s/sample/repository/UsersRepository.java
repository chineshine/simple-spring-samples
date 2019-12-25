package c.s.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import c.s.sample.model.Users;

/**
 * @author chineshine
 * @date 2019年12月25日
 *
 */
@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{

	
}
