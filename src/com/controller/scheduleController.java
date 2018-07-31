package com.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.json.JSONException;
import org.json.JSONObject;

import com.dao.requirementDAO;
import com.dao.scheduleDAO;

/**
 * Servlet implementation class scheduleController
 */
@WebServlet("/scheduleController")
public class scheduleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="oracledb")
	private DataSource dataSource;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public scheduleController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		scheduleDAO.dataSource = this.dataSource;
		
		InputStreamReader reader = new InputStreamReader(request.getInputStream());
		BufferedReader br = new BufferedReader(reader);
		String jsonString = br.readLine();
		System.out.println(jsonString);
		
		response.getWriter().write("success");
		
		JSONObject jsonOb;
		String name="",qualification="",mode="",venue="";
		int vacancies=0,minexp=0;
		try {
			jsonOb = new JSONObject(jsonString);
			name = jsonOb.getString("name");
			qualification = jsonOb.getString("qualification");
			mode = jsonOb.getString("mode");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
		}
		
		
		int res=scheduleDAO.addSchedule(1,name,qualification,mode);
		if(res>0)
		{
			response.getWriter().write("angular");
			System.out.println("requirement added");
		}
	}
		
	}


