package c.s.sample.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import c.s.sample.user.entity.Users;


/**
 * @author chineshine
 * @date 2019年12月25日
 *
 */
@Repository
public interface UsersRepository extends JpaRepositoryImplementation<Users, Long>{

	Optional<Users> findByIdAndEnabledFalse(Long id);
	
}
