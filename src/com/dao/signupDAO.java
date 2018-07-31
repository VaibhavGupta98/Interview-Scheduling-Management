package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class signupDAO {
	
public static DataSource dataSource;
	
	public signupDAO(DataSource source) {
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
	
	public static int addUser(int id,String name,String username,String password)
	{
		int result=0;
		Connection con=null;
		try {
			con=getConnection();
			ResultSet r= con.prepareStatement("SELECT signup_seq.nextval from signup").executeQuery();
			int id1=0;
			if(r.next()) {
			id1= r.getInt(1);
			}
			String sql="INSERT INTO signup VALUES(?,?,?,?)";
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setInt(1,id1);
			ps.setString(2, name);
			ps.setString(3, username);
			ps.setString(4, password);
			result= ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeConnection(con);
		}
		return result;
	}
	

}
