package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.bo.Candidate;


public class scheduleDAO {
	
	public static DataSource dataSource;
	
	public scheduleDAO(DataSource source) {
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
	
	public static int addSchedule(int rid,String name,String qualification,String venue) {
		int res=0;
		Connection con=null;
		PreparedStatement ps=null;
		String sql="INSERT INTO schedule VALUES(?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			res= ps.executeUpdate();
			if(res>0) {
				System.out.println("schedule added");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
		
	}
	

}
