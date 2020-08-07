package c.s.sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.IdTokenClaimNames;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SuppressWarnings({ "deprecation" })
@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().anyRequest().authenticated();
		http.formLogin().and().httpBasic();
		http.oauth2Login();
	}
	
	@Bean
	public ClientRegistrationRepository clientRegistrationRepository() {
		return new InMemoryClientRegistrationRepository(client1Registration());
	}

	private ClientRegistration client1Registration() {
		return ClientRegistration.withRegistrationId("client1").clientId("client1")
				.clientSecret("123456").clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
				.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
				.redirectUriTemplate("http://localhost:11001/")
//				.scope("openid", "profile", "email", "address", "phone")
				.scope("write")
				.authorizationUri("http://localhost:8080/oauth/authorize")
				.tokenUri("http://localhost:8080/oauth/token")
				.userInfoUri("http://localhost:8080/api/users/me")
				.userNameAttributeName(IdTokenClaimNames.SUB).jwkSetUri("http://localhost:8080/.well-known/jwks.json")
				.clientName("client1").build();
	}

	@Bean
	public UserDetailsService users() {
		UserDetails user = User.withDefaultPasswordEncoder().username("zhangsan").password("password").roles("USER")
				.build();
		return new InMemoryUserDetailsManager(user);
	}

}
