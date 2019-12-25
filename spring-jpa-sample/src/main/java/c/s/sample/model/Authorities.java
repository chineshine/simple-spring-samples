package c.s.sample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author chineshine
 * @date 2019年12月25日
 *
 */
@Data
@Entity
@Table(name = "authorities")
public class Authorities {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	private String username;

	private String authority;
}
