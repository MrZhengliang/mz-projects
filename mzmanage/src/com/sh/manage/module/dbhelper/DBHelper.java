/**
 * 
 */
package com.sh.manage.module.dbhelper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;

/**
 * 数据库访问通用类
 * @author fuzl
 * 
 */
public class DBHelper {

	private String sql; // 要传入的sql语句

	public void setSql(String sql) {
		this.sql = sql;
	}

	@SuppressWarnings("rawtypes")
	private List sqlValues; // sql语句的参数

	@SuppressWarnings("rawtypes")
	public void setSqlValues(List sqlValues) {
		this.sqlValues = sqlValues;
	}

	private Connection con; // 连接对象

	public void setCon(Connection con) {
		this.con = con;
	}

	public DBHelper() {
		this.con = getConnection(); // 给Connection的对象赋初值
	}

	/**
	 * 获取数据库连接
	 * 
	 * @return
	 */
	private Connection getConnection() {

		String driver_class = null;
		String driver_url = null;
		String database_user = null;
		String database_password = null;
		try {
			InputStream fis = this.getClass().getResourceAsStream(
					"/db.properties"); // 加载数据库配置文件到内存中
			Properties p = new Properties();
			p.load(fis);

			driver_class = p.getProperty("driver_class"); // 获取数据库配置文件
			driver_url = p.getProperty("driver_url");
			database_user = p.getProperty("database_user");
			database_password = p.getProperty("database_password");

			Class.forName(driver_class);
			con = (Connection) DriverManager.getConnection(driver_url,
					database_user, database_password);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	/**
	 * 关闭数据库
	 * 
	 * @param con
	 * @param pst
	 * @param rst
	 */
	private void closeAll(Connection con, PreparedStatement pst, ResultSet rst) {
		if (rst != null) {
			try {
				rst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (pst != null) {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * 查找
	 * 
	 * @param sql
	 * @param sqlValues
	 * @return
	 */
	public Result executeQuery() {
		Result result = null;
		ResultSet rst = null;
		PreparedStatement pst = null;
		try {

			pst = con.prepareStatement(sql);
			if (sqlValues != null && sqlValues.size() > 0) { // 当sql语句中存在占位符时
				setSqlValues(pst, sqlValues);
			}
			rst = pst.executeQuery();
			result = ResultSupport.toResult(rst); // 一定要在关闭数据库之前完成转换
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(con, pst, rst);
		}

		return result;
	}

	
	
	
	/**
	 * 查找返回resultSet；需要手动关闭
	 * 
	 * @param sql
	 * @param sqlValues
	 * @return
	 */
	public ResultSet executeQueryRs() {
		ResultSet rst = null;
		PreparedStatement pst = null;
		try {

			pst = con.prepareStatement(sql);
			if (sqlValues != null && sqlValues.size() > 0) { // 当sql语句中存在占位符时
				setSqlValues(pst, sqlValues);
			}
			rst = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return rst;
	}
	
	
	/**
	 * 增删改
	 * 
	 * @return
	 */
	public int executeUpdate() {
		int result = -1;
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql);
			if (sqlValues != null && sqlValues.size() > 0) { // 当sql语句中存在占位符时
				setSqlValues(pst, sqlValues);
			}
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(con, pst, null);
		}

		return result;
	}

	/**
	 * 给sql语句中的占位符赋值
	 * 
	 * @param pst
	 * @param sqlValues
	 */
	@SuppressWarnings("rawtypes")
	private void setSqlValues(PreparedStatement pst, List sqlValues) {
		for (int i = 0; i < sqlValues.size(); i++) {
			try {
				pst.setObject(i + 1, sqlValues.get(i));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
