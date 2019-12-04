/*
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package c.s.sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author Joe Grandja
 */
/**
	1. 这是 spring 官方例子
	2. 如果使用这个例子,请注释 securityConfiguration 这个类
	3. 打开这个类的 <code> @EnableWebSecurity </code> <code>@Bean</code> 注解
	4. 打开 38行 extends 注解
 */
//@EnableWebSecurity
public class SecurityConfig {
// spring 官方例子 
//	extends WebSecurityConfigurerAdapter {

	// @formatter:off
//	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests(authorizeRequests ->
					authorizeRequests
						.antMatchers("/css/**", "/index").permitAll()
						.antMatchers("/user/**").hasRole("USER")
				)
				.formLogin(formLogin ->
					formLogin
						.loginPage("/login")
						.failureUrl("/login-error")
				);
//		http.csrf().disable();
//		http.headers().frameOptions().disable();
	}
	// @formatter:on

//	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails userDetails = User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(userDetails);
	}
}
