package c.s.sample.jpa;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author chineshine
 * @since  2020年6月8日
 */
@NoRepositoryBean
public interface BasisEntityRepository<T extends BasisEntity,ID extends Serializable> extends JpaRepositoryImplementation<T, ID> {

	Optional<T> findByUuid(String uuid);
	
//	Optional<T> findByIdAndDeletedFalse(ID id);

}
