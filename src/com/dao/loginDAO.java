package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class loginDAO {

	public static DataSource dataSource;
	
	public loginDAO(DataSource source) {
		this.dataSource= source;
	}
	
	
	
	
	
	private static  Connection getConnection() {
		Connection con=null;
		try {
			con=dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	private static  void closeConnection(Connection con) {
		try {
			if(con!=null)
				con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public static boolean checkUser(String username, String password) {
		// TODO Auto-generated method stub
		Connection con=null;
		boolean res=false;
		String sql= "SELECT * from signup where username=? and password=?";
		try {
			con=getConnection();
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				res=true;
			}
			return res;
		}
		catch(SQLException e) {
			System.out.println("exception");
			e.printStackTrace();
		}
		return res;
	}

}
