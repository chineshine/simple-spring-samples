package c.s.sample.jpa;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * @author chineshine
 * @since  2020年6月8日
 */
public class BasisEntityListener {

	@PrePersist
	public void insert(BasisEntity entity) {
		final String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		final LocalDateTime currentTime = LocalDateTime.now(ZoneId.systemDefault());
		entity.setUuid(uuid);
		entity.setDeleted(false);
		entity.setInsertTime(currentTime);
		entity.setUpdateTime(currentTime);
	}

	@PreUpdate
	public void update(BasisEntity entity) {
		final LocalDateTime currentTime = LocalDateTime.now(ZoneId.systemDefault());
		entity.setUpdateTime(currentTime);
	}

}
