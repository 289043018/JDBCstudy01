package com.hand.JDBCTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class trancetionTest {
	
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
	
	public static void insertuserdate(Connection conn) throws SQLException{
		
			String sql = "INSERT INTO tbl_user(id,name,password,email)"+
		"VALUES(10,'TOM','123456','TOM@GMAIL.COM')";
			Statement st = conn.createStatement();
			//executeUpdate语句可以实现insert，update，delete以及没有返回结果的SQL语句
			
			int count = st.executeUpdate(sql);
			System.out.println("向用户表中插入了"+count+"条记录");
			
		
	}
	
	public static void insertaddressdate(Connection conn) throws SQLException{
		
			String sql = "INSERT INTO tbl_address(id,city,country,user_id)"+
		"VALUES(1,'shanghai','china','10')";
			Statement st = conn.createStatement();
			//executeUpdate语句可以实现insert，update，delete以及没有返回结果的SQL语句
			
			int count = st.executeUpdate(sql);
			System.out.println("向地址表中插入了"+count+"条记录");
			
		
	}
	
	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn =getConnection();
			conn.setAutoCommit(false);
			insertuserdate(conn);
			insertaddressdate(conn);
			
			conn.commit();
		} catch (SQLException e) {
			System.out.println("===============捕获到SQL异常===============");
			
			e.printStackTrace();
			try {
				conn.rollback();
				System.out.println("==========事务回滚成功===================");
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}finally{
			try{
				if(conn != null){
					conn.close();
				}
			}catch(Exception e3){
				e3.printStackTrace();
			}
		}
		
	}
	
	

}
