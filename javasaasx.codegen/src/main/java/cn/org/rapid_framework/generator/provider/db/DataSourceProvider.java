package cn.org.rapid_framework.generator.provider.db;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import cn.org.rapid_framework.generator.GeneratorConstants;
import cn.org.rapid_framework.generator.GeneratorProperties;
import cn.org.rapid_framework.generator.util.GLogger;
import cn.org.rapid_framework.generator.util.StringHelper;
/**
 * 用于提供生成器的数据源
 * 
 * @author badqiu
 *
 */
public class DataSourceProvider extends CommonDataSourceProvider{

	private static DataCollectionInfo buildDataCollectionInfo(){
		DataCollectionInfo collectionInfo = new DataCollectionInfo();
		collectionInfo.setUrl(GeneratorProperties.getRequiredProperty(GeneratorConstants.JDBC_URL));
		collectionInfo.setUsername(GeneratorProperties.getRequiredProperty(GeneratorConstants.JDBC_USERNAME));
		collectionInfo.setPassword(GeneratorProperties.getProperty(GeneratorConstants.JDBC_PASSWORD));
		collectionInfo.setDriverClass(GeneratorProperties.getRequiredProperty(GeneratorConstants.JDBC_DRIVER));
		return collectionInfo;
	}

	public synchronized static Connection getNewConnection() {
		return getNewConnection(buildDataCollectionInfo());
	}

	public synchronized static Connection getConnection() {
		return getConnection(buildDataCollectionInfo());
	}

	public synchronized static DataSource getDataSource() {
		return getDataSource(buildDataCollectionInfo());
	}

}
