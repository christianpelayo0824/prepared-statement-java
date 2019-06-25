package com.maven.api.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConfig {

	private final static Logger LOGGER = Logger.getLogger(DatabaseConfig.class.getName());

	private final String DB_USERNAME = "root";
	private final String DB_PASSWORD = "";
	private final String DB_URL = "jdbc:mysql://localhost:3306/local_db";
	private final String DRIVER_NAME = "com.mysql.jdbc.Driver";

	private Connection conn;
	private Statement stmt;

	public DatabaseConfig() {
		super();
	}

	public void connect() throws SQLException {
		try {
			Class.forName(DRIVER_NAME);
			LOGGER.log(Level.INFO, "Connecting...");
			this.conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			this.stmt = conn.createStatement();
			LOGGER.log(Level.INFO, "Connection Established!");
		} catch (ClassNotFoundException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
	}

	public void closeConnection() {
		try {
			this.conn.close();
			this.stmt.close();
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
	}

	public Statement getStatement() {
		return this.stmt;
	}

	public Connection getConnection() {
		return this.conn;
	}

}
