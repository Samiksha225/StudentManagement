package ai.rnt.dbconnect;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.CommonDataSource;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import ai.rnt.constant.DbConstant;

public class DbConnection {
	public static DataSource dataSource = null;

	public static CommonDataSource getDataSource() throws PropertyVetoException {
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass(DbConstant.DRIVER_CLASS_NAME);
		cpds.setJdbcUrl(DbConstant.DB_URL);
		cpds.setUser(DbConstant.DB_USER);
		cpds.setPassword(DbConstant.DB_PASSWORD);

//		optional settings
		cpds.setInitialPoolSize(10);
		cpds.setMinPoolSize(5);
		cpds.setAcquireIncrement(5);
		cpds.setMaxPoolSize(20);
		cpds.setMaxStatements(100);
		cpds.setMaxIdleTime(2);
		dataSource = cpds;
		return cpds;
	}

	public static Connection getConnection() throws SQLException, PropertyVetoException {
		if (dataSource == null) {
			dataSource = (ComboPooledDataSource) getDataSource();
		}
		Connection connection = dataSource.getConnection();
		connection.setAutoCommit(true);
		return connection;
	}
}