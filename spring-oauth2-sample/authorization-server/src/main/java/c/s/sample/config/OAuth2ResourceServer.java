package c.s.sample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableResourceServer
public class OAuth2ResourceServer extends ResourceServerConfigurerAdapter {

	private @Autowired TokenStore tokenStore;
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		// 此处需要定义 tokenstore,默认使用的是使用内存的 InMemoryTokenStore
		resources.tokenStore(tokenStore)
//		spring 会根据 TokenStore 生成默认的 TokenExtractor,可不定义
//		.tokenExtractor(TokenExtractor)

		//		spring 会根据 TokenStore 生成 tokenService, 可不定义
//		TokenService 会定义 ClientDetailsService,Spring 会获取共享的 ClientDetailService,故而无需定义
//		即如果在 AuthorizationServer 中定义了 ClientDetailService 此处无需再次定义
//		.tokenServices(tokenServices)
		;
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests(
				x -> x
				// 只拦截 api 的接口
					.antMatchers("/api/**").authenticated()
				// 后续接口由 @EnableWebSecurity 定义的过滤器拦截
					.antMatchers("/").permitAll()
					);
		// 此处不支持 httpBasic 认证,由后续的过滤器支持
		http.httpBasic().disable();
	}
	
}
