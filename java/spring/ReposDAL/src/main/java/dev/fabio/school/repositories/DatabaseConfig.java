package dev.fabio.school.repositories;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mysql.cj.jdbc.MysqlDataSource;

@Configuration
public class DatabaseConfig {

	@Bean
	public DataSource dataSource() throws SQLException {
		MysqlDataSource ds = new MysqlDataSource();
		ds.setServerName("localhost");
		ds.setPortNumber(3306);
		ds.setUser("root");
		ds.setPassword("pennare77a");
		ds.setDatabaseName("spring_api_school");
		ds.setUseSSL(false);
		ds.setAllowPublicKeyRetrieval(true);
					
		return ds;
	}
	
	@Bean
	public Connection connection(DataSource ds) throws SQLException {
		return ds.getConnection();
	}
	
}
