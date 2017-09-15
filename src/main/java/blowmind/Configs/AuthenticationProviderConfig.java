package blowmind.Configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

@Configuration
public class AuthenticationProviderConfig {

	@Autowired
	private DatabaseConfig databaseConfig;

	@Bean(name="userDetailsService")
	public UserDetailsService userDetailsService() {
		JdbcDaoImpl jdbcImpl = new JdbcDaoImpl();
		jdbcImpl.setDataSource(databaseConfig.dataSource());
		
		jdbcImpl.setUsersByUsernameQuery("SELECT email as username, password, confirmed as enabled, CONCAT(SUBSTRING_INDEX(name, ' ', 1),' ',SUBSTRING_INDEX(name, ' ', -1)) AS showname, id as id FROM users where email=?");
		jdbcImpl.setAuthoritiesByUsernameQuery("SELECT email as username, role FROM users where email=?");
		
		return jdbcImpl;
	}

}
