package dev.fabio.school.repositories;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

public class ConnectionSingleton {

	private static ConnectionSingleton instance;
	
	private ConnectionSingleton() { }
	
	public static ConnectionSingleton getInstance() {
		if (instance == null) instance = new ConnectionSingleton();
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		MysqlDataSource ds = new MysqlDataSource();
		ds.setServerName("localhost");
		ds.setPortNumber(3306);
		ds.setUser("root");
		ds.setPassword("pennare77a");
		ds.setDatabaseName("spring_api_school");
		ds.setUseSSL(false);
		ds.setAllowPublicKeyRetrieval(true);
					
		return ds.getConnection();
	}
	
}
