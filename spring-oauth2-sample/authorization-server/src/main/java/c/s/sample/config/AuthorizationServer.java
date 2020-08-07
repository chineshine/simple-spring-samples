package c.s.sample.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

/**
 * @author chineshine
 * @date 2019年12月5日
 *
 */
@SuppressWarnings("deprecation")
@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {

	private @Autowired AuthenticationConfiguration authenticationConfiguration;
//	private @Autowired AuthenticationManager authenticationManager;

	private @Autowired TokenStore tokenStore;

	private @Autowired DataSource dataSource;

	private @Autowired JwtAccessTokenConverter jwtAccessTokenConverter;

	private @Autowired PasswordEncoder passwordEncoder;

	/**
	 * 放开 Token检查 和 公钥请求 的端点
	 */
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()")
				.allowFormAuthenticationForClients();
	}

	/**
	 * 客户端定义
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		ClientDetailsService clientDetailsService = clients.jdbc(dataSource).passwordEncoder(passwordEncoder)
// 下面两句注释不能用,因为 spring 不会像 users表 那样自动创建表oauth_client_details
		// .withClient("cli1").secret(passwordEncoder.encode("123456")).accessTokenValiditySeconds(600_000_000)
//				.and()
				.build();
		clients.withClientDetails(clientDetailsService);
	}

	/**
	 * 定义授权,token终端和token服务
	 */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints
//			.authenticationManager(authenticationManager)
			.authenticationManager(authenticationConfiguration.getAuthenticationManager())
			.tokenStore(tokenStore)
			.accessTokenConverter(jwtAccessTokenConverter);
	}

}
