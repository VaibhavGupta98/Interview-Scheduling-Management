package com.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.json.JSONException;
import org.json.JSONObject;


import com.bo.Record;

import com.dao.recordDAO;
import com.dao.requirementDAO;
import com.dao.signupDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class recordController
 */
@WebServlet("/recordController")
public class recordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="oracledb")
	private DataSource dataSource;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public recordController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		recordDAO.dataSource = this.dataSource;
		List list =  recordDAO.getAllRecords();
		
		//System.out.println(list);
		System.out.println("shown");
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		String jsonString = gson.toJson(list);
		response.getWriter().print(jsonString);
		System.out.println("shown records");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		recordDAO.dataSource = this.dataSource;
		
		InputStreamReader reader = new InputStreamReader(request.getInputStream());
		BufferedReader br = new BufferedReader(reader);
		String jsonString = br.readLine();
		System.out.println(jsonString);
		
		JSONObject jsonOb;
		String name="",result="";
		int marks=0;
		try {
			jsonOb = new JSONObject(jsonString);
			name = jsonOb.getString("name");
			result = jsonOb.getString("result");
			marks = jsonOb.getInt("marks");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		int res=recordDAO.addRecord(1,name,2,marks,result);
		if(res>0)
		{
			response.getWriter().write("angular");
			System.out.println("added");
		}
		
	}

}
