package blowmind.Configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;

import blowmind.Configs.Encrypt;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	public Encrypt encrypt;
	
	@Autowired
	CustomSuccessHandler customSuccessHandler;
	
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
			auth.userDetailsService(userDetailsService)
				.passwordEncoder(encrypt.passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		http
        .authorizeRequests()
        .antMatchers("/assets/**", "/js/**", "/css/**", "/img/**", "/fonts/**","/font-awesome/**","/", "/login", "/contact", "/recruit").permitAll()
        .anyRequest().authenticated()
        .and()
        .httpBasic()
        .and()
    .formLogin()
        .loginPage("/login")
        .permitAll()
        .successHandler(customSuccessHandler)
        .and()
     .sessionManagement()
		.maximumSessions(-1)
		.sessionRegistry(sessionRegistry())
		.expiredUrl("/logout")
		.sessionRegistry(sessionRegistry())
		.and().and().csrf().disable()
    .logout()
	    .logoutUrl("/logout")
	    .logoutSuccessUrl("/login?logout")
	    .invalidateHttpSession(true)
	    .permitAll()
	    .and()
	.exceptionHandling()
		.accessDeniedPage("/403")
		.and()
	.rememberMe()
		.tokenValiditySeconds(1209600);
			
	}
	
	@Bean(name = "sessionRegistry")
	public SessionRegistry sessionRegistry() {
		return new SessionRegistryImpl();
	}
}
