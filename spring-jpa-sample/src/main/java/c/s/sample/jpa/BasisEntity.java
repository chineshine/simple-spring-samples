package c.s.sample.jpa;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Where;

import lombok.Data;

/**
 * @author chineshine
 * @since  2020年6月8日
 */
@Data
@MappedSuperclass
@EntityListeners(BasisEntityListener.class)
@Where(clause = " deleted = 0 ")
public class BasisEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Boolean deleted;

	private String uuid;

	@Column(name = "INSERT_TIME", updatable = false)
	private LocalDateTime insertTime;

	@Column(name = "UPDATE_TIME")
	private LocalDateTime updateTime;
}
