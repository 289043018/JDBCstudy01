package com.hand.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.hand.Entity.User;

public interface UserDao {
	public void save(Connection conn,User user)throws SQLException;
	
	public void update(Connection conn,long id,User user)throws SQLException;
	
	public void delete(Connection conn,User user)throws SQLException;
	
}
