package com.hand.JDBCTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.UpdatableResultSet;

public class JDBCTses {
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//获取数据库连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_db","root","root");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void insert(){
		Connection conn = getConnection();
		try {
			String sql = "INSERT INTO tbl_user(name,password,email)"+
		"VALUES('TOM','123456','TOM@GMAIL.COM')";
			Statement st = conn.createStatement();
			//executeUpdate语句可以实现insert，update，delete以及没有返回结果的SQL语句
			
			int count = st.executeUpdate(sql);
			System.out.println("向用户表中插入了"+count+"条记录");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void update(){
		Connection conn = getConnection();
		try {
			String sql = "UPDATE tbl_user SET email='tom@126.com' WHERE name = 'TOM'";
			Statement st = conn.createStatement();
			//executeUpdate语句可以实现insert，update，delete以及没有返回结果的SQL语句
			
			int count = st.executeUpdate(sql);
			System.out.println("向用户表中更新了"+count+"条记录");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void delete(){
		Connection conn = getConnection();
		try {
			String sql = "DELETE FROM tbl_user WHERE name='TOM'";
			Statement st = conn.createStatement();
			//executeUpdate语句可以实现insert，update，delete以及没有返回结果的SQL语句
			
			int count = st.executeUpdate(sql);
			System.out.println("向用户表中删除了"+count+"条记录");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		insert();
//		update();
		delete();
	}

}
