package com.example.demo.source;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class MyDataSource {
//	private static final String DB_USERNAME = "spring.datasource.username";
//	private static final String DB_PASSWORD = "spring.datasource.password";
//	private static final String DB_URL = "spring.datasource.url";
//    private static final String DB_DRIVER_CLASS="spring.datasource.driver-class-name";

	private static Properties properties = null;
	private static HikariDataSource dataSource;

	static {
		try { 
//			properties = new Properties();
//			properties.setProperty("dataSourceClassName", "org.postgresql.ds.PGSimpleDataSource");
//			properties.setProperty("dataSource.user", "ipjysrzrqknxwh");
//			properties.setProperty("dataSource.password", "e7b306bbf64c0fc560492554b59ceb12806724a8c6641155452faa94413045a3");
//			properties.setProperty("dataSource.databaseName", "deovkcvn172ljp");
//			properties.put("dataSource.logWriter", new PrintWriter(System.out));
			
			properties = new Properties();
			properties.setProperty("dataSourceClassName", "org.postgresql.ds.PGSimpleDataSource");
			properties.setProperty("dataSource.user", "postgres");
			properties.setProperty("dataSource.password", "2403");
			properties.setProperty("dataSource.databaseName", "postgres");
			properties.put("dataSource.logWriter", new PrintWriter(System.out));

			HikariConfig config = new HikariConfig(properties);
			dataSource = new HikariDataSource(config);
//			properties.load(new FileInputStream("src/main/resources/application.properties"));
//
//			dataSource = new HikariDataSource();
////            dataSource.setDriverClassName(properties.getProperty(DB_DRIVER_CLASS));
//
//			dataSource.setJdbcUrl(properties.getProperty(DB_URL));
//			dataSource.setUsername(properties.getProperty(DB_USERNAME));
////            dataSource.setPassword(AesEncript.decrypt(properties.getProperty(DB_PASSWORD)));
//			dataSource.setPassword(DB_PASSWORD);
//
//			dataSource.setMinimumIdle(100);
//			dataSource.setMaximumPoolSize(2000);
//			dataSource.setAutoCommit(false);
//			dataSource.setLoginTimeout(3);

		} catch (Exception e) {
			System.out.println("CONN NOT ESTABLISH : "+e);
			((Throwable) e).printStackTrace();
		}
	}

	public static DataSource getDataSource() {
		return dataSource;
	}

	public static Connection getConnection() throws SQLException {
		return getDataSource().getConnection();
	}
}