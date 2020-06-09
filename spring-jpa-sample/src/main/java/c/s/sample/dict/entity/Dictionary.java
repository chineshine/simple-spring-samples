package c.s.sample.dict.entity;

import javax.persistence.Entity;

import c.s.sample.jpa.BasisEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author chineshine
 * @since  2020年6月8日
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Dictionary extends BasisEntity {

	private String name;

	private String description;

	private Long parentId;
}
