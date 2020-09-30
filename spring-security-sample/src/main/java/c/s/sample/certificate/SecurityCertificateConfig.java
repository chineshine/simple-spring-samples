package c.s.sample.certificate;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import c.s.sample.config.AsyncAuthenticationFailureHandler;
import c.s.sample.config.AsyncAuthenticationSuccessHandler;

//@EnableWebSecurity
public class SecurityCertificateConfig extends WebSecurityConfigurerAdapter{

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
        AsyncAuthenticationSuccessHandler successHandler = new AsyncAuthenticationSuccessHandler();
        AsyncAuthenticationFailureHandler failureHandler = new AsyncAuthenticationFailureHandler();
        
        CertificateProvider provider = new CertificateProvider();
        http.authenticationProvider(provider);
        CertificateFilter certificateFilter = new CertificateFilter();
//        super.authenticationManager()   此处必须用 authenticationManagerBean, 否则 provider 无法起作用
//        此处 authenticationManagerBean 会通过 setAuthenticationManagerBuilder 重新构建,
//        authenticationProvider 是通过 AuthenticationManagerBuilder 注入到 authenticationManager 中
        certificateFilter.setAuthenticationManager(super.authenticationManagerBean());
        certificateFilter.setAuthenticationSuccessHandler(successHandler);
        certificateFilter.setAuthenticationFailureHandler(failureHandler);
        http.addFilterAt(certificateFilter, UsernamePasswordAuthenticationFilter.class);

        http.formLogin().loginProcessingUrl("/login");
	}
}
