package com.hand.testdao;

import java.sql.Connection;

import com.hand.Entity.User;
import com.hand.dao.UserDao;
import com.hand.dao.impl.UserDaoImpl;
import com.hand.util.ConnectionFactory;

public class UserDaoTest {

	public static void main(String[] args) {
		Connection conn =null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			
			UserDao userDao = new UserDaoImpl();
			User tom = new User();
			tom.setName("Tom");
			tom.setPassword("123456");
			tom.setEmail("tom@163.com");
			
//			userDao.save(conn, tom);
//			userDao.update(conn, 12, tom);
			userDao.delete(conn, tom);
			conn.commit();
			
			
			
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

			
		}
	}

}
