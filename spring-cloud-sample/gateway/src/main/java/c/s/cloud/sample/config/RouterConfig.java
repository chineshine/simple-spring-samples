package c.s.cloud.sample.config;

import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * @author chineshine
 * @since  2020年8月14日
 */
@SuppressWarnings("deprecation")
@Configuration
public class RouterConfig {

	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder) {
		return builder.routes().route("path_route", r -> r.path("/get").uri("http://httpbin.org"))
				.route("host_route", r -> r.host("*.myhost.org").uri("http://httpbin.org"))
				.route("rewrite_route",
						r -> r.host("*.rewrite.org").filters(f -> f.rewritePath("/foo/(?<segment>.*)", "/${segment}"))
								.uri("http://httpbin.org"))
				.route("hystrix_route",
						r -> r.host("*.hystrix.org").filters(f -> f.hystrix(c -> c.setName("slowcmd")))
								.uri("http://httpbin.org"))
				.route("hystrix_fallback_route",
						r -> r.host("*.hystrixfallback.org").filters(
								f -> f.hystrix(c -> c.setName("slowcmd").setFallbackUri("forward:/hystrixfallback")))
								.uri("http://httpbin.org"))
				.route("limit_route",
						r -> r.host("*.limited.org").and().path("/anything/**")
								.filters(f -> f.requestRateLimiter(c -> c.setRateLimiter(redisRateLimiter())))
								.uri("http://httpbin.org"))
				.route("websocket_route", r -> r.path("/echo").uri("ws://localhost:9000")).build();
	}

	// 请求频率限制
	@Bean
	RedisRateLimiter redisRateLimiter() {
		return new RedisRateLimiter(1, 2);
	}
	
	
	@Bean
	SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http) throws Exception {
		return http.httpBasic().and()
				.csrf().disable()
				.authorizeExchange()
				.pathMatchers("/anything/**").authenticated()
				.anyExchange().permitAll()
				.and()
				.build();
	}

	@Bean
	public MapReactiveUserDetailsService reactiveUserDetailsService() {
		UserDetails user = User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build();
		return new MapReactiveUserDetailsService(user);
	}
}
