package c.s.sample.pojo;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

/**
 * @author chineshine
 * @since  2020年3月16日
 */
public class Greeting extends RepresentationModel<Greeting>{

	@Getter
	private final String content;

	@JsonCreator
	public Greeting(@JsonProperty("content") String content) {
		this.content = content;
	}

	/**
		@JsonCreator: 用在构造方法上,告诉 Jackson 怎样去创建这个 Pojo 的实例
		@JsonProperty: 标志该字段用于创建实例的构造体中
	 */
	
}
