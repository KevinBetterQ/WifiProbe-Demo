package com.wifi.db;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

//单例模式
public class DbUtils {
	private DbUtils(){}
	private static final String url = "jdbc:mysql://127.0.0.1/test";
	private static final String user = "root";
	private static final String password = "******";
	
	
	//静态区域，只加载一次
	static
	{
		//1.创建驱动类对象
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//获取连接
	public static Connection getConnection() {
		Connection connection=null;
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	//关闭
	public static void  closeConnection(Connection connection) {
		if(connection!=null){
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void closePreparedStatement(PreparedStatement pstmt) {
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
