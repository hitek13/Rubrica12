package es.salesianos.edu.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractConnectionManager implements ConnectionManager {

	private static final Logger logger = LogManager.getLogger(AbstractConnectionManager.class.getName());

	protected abstract String getJdbcUrl();

	protected abstract String getClassDriver();

	protected abstract String getUser();

	protected abstract String getPass();

	private Connection conn = null;

	public Connection open() {
		try {
			Class.forName(getClassDriver());
			conn = DriverManager.getConnection(getJdbcUrl(), getUser(), getPass());
		} catch (Exception e) {
			logger.error(e);
			throw new RuntimeException(e);
		}
		return conn;
	}

	public void close(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				logger.error(e);
				throw new RuntimeException(e);
			}
		}
	}

	public void close(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				logger.error(e);
				throw new RuntimeException(e);
			}
		}
	}


	public void close(Connection connection) {

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				logger.error(e);
				throw new RuntimeException(e);
			}
		}

	}

}
