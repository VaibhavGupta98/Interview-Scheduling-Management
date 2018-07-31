package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.bo.Record;

public class recordDAO {
	
public static DataSource dataSource;
	
	public recordDAO(DataSource source) {
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
	
	public static List<Record> getAllRecords(){
		List<Record> recList = new ArrayList<>();
		PreparedStatement ps =null;
		Connection con=null;
		String sql="SELECT requirementid,name,interviewid,marks,result FROM record";
			try {
				con=getConnection();
				ps=con.prepareStatement(sql);
				ResultSet rs= ps.executeQuery();
				while(rs.next()) {
					int rid= rs.getInt(1);
					String name= rs.getString(2);
					int inid= rs.getInt(3);
					int marks = rs.getInt(4);
					String res= rs.getString(5);
					recList.add(new Record(rid,name,inid,marks,res));
				}
				
				System.out.println(recList);
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return recList;
		
	}
	
	public static int addRecord(int requirementid,String name,int interviewid,int marks,String result) {
		Connection con=null;
		PreparedStatement ps=null;
		int res=0;
		String sql = "INSERT INTO record VALUES(?,?,?,?,?)";
		try {
			con=getConnection();
		    ps= con.prepareStatement(sql);
		    ps.setInt(1, requirementid);
		    ps.setString(2 , name);
		    ps.setInt(3, interviewid);
		    ps.setInt(4, marks);
		    ps.setString(5, result);
			res=ps.executeUpdate();
			if(res>0)
			{
				System.out.println("record added successfully");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	
	
	
	

}
