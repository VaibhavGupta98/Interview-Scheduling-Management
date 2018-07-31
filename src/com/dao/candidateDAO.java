package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.bo.Candidate;

public class candidateDAO {
	
public static DataSource dataSource;
	
	public candidateDAO(DataSource source) {
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
	
	public static List<Candidate> getAllCandidates(){
		List<Candidate> candidateList= new ArrayList<>();
		PreparedStatement ps=  null;
		Connection con=null;
		con=getConnection();
		String sql= "SELECT firstname,password,email,contact from candidateDetails"; 
		try {
			ps=con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				String firstname= rs.getString("firstname");
				String password= rs.getString("password");
				String email= rs.getString("email");
				int contact = rs.getInt("contact");
				candidateList.add(new Candidate(firstname,password,email,contact));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return candidateList;
	}
	
	
	

}
