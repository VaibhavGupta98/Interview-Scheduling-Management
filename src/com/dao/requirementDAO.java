package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.bo.Record;
import com.bo.Requirement;

public class requirementDAO {
	
	
public static DataSource dataSource;
	
	public requirementDAO(DataSource source) {
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
	
	public static int addRequirement(String requesteddate,String closingdate,String domain,
			int vacancies,int minexperience,String modeinterview )
	{
		int result=0;
		Connection con=null;
		try {
			con=getConnection();
			String sql="INSERT INTO candidateRequirement VALUES(?,?,TO_DATE(?,'YYYY-MM-DD'),TO_DATE(?,'YYYY-MM-DD'),?,?,?,?)";
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setInt(1,4);
			ps.setInt(2,4);
			ps.setString(3,requesteddate);
			ps.setString(4, closingdate);
			ps.setInt(5,vacancies);
			ps.setInt(6, minexperience);
			ps.setString(7,modeinterview);
			ps.setString(8,domain);
			
			result= ps.executeUpdate();
			if(result>0) {
				System.out.println("requirement added");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	
	}
	
	public static List getAllReqid() {
		List reqidList = new ArrayList<>();
		PreparedStatement ps =null;
		Connection con=null;
		System.out.println("getAllReqid");
		String sql="SELECT * FROM candidateRequirement";
			try {
				ps=con.prepareStatement(sql);
				ResultSet rs= ps.executeQuery();
				while(rs.next()) {
					int rid= rs.getInt("requirementid");
					reqidList.add(rid);
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return reqidList;
		
	}
	
	
//	public static List<Requirement> getAllRequirements(){
//		List<Requirement> requirementList = new ArrayList<>();
//		PreparedStatement ps =null;
//		Connection con=null;
//		String sql="SELECT id,requirementid,requesteddate,closingdate,vacancies,minexperience,modeinterview,domain FROM candidateRequirement";
//			try {
//				ps=con.prepareStatement(sql);
//				ResultSet rs= ps.executeQuery();
//				while(rs.next()) {
//					int id= rs.getInt(1);
//					int rid=rs.getInt(2);
//					Date reqdate = rs.getDate(3);
//					Date closedate= rs.getDate(4);
//					int vacancies= rs.getInt(5);
//					int minexp = rs.getInt(6);
//					String mode= rs.getString(7);
//					String domain= rs.getString(8);
//					requirementList.add(new Requirement(id,rid,reqdate, closedate,vacancies,minexp,mode,domain));
//				}
//				rs.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return requirementList;
//		
//	}
}
