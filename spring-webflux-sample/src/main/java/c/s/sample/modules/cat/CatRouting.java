package c.s.sample.modules.cat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author chineshine
 * @date 2020年1月3日
 *
 */
@Configuration
public class CatRouting {

	@Bean
	public RouterFunction<ServerResponse> catRouterFunction(CatHandler catHandler){
		return RouterFunctions.route(RequestPredicates.GET("/cat"),catHandler::getCat);
	}
}
