package c.s.sample.modules.cat;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

/**
 * @author chineshine
 * @date 2020年1月3日
 *
 */
@Component
public class CatHandler {

	public Mono<ServerResponse> getCat(ServerRequest serverRequest){
		return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).bodyValue("this is a cat");
	}
	
	
}
