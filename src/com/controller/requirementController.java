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
 * Servlet implementation class requirementController
 */
@WebServlet("/requirementController")
public class requirementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="oracledb")
	private DataSource dataSource;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public requirementController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		requirementDAO.dataSource = this.dataSource;
//		List list =  requirementDAO.getAllRequirements();
//		
//		//System.out.println(list);
//		System.out.println("shown");
//		GsonBuilder gsonBuilder = new GsonBuilder();
//		Gson gson = gsonBuilder.create();
//		String jsonString = gson.toJson(list);
//		response.getWriter().print(jsonString);
//		System.out.println("shown requirements");
		
		
		requirementDAO.dataSource = this.dataSource;
		List list =  requirementDAO.getAllReqid();
		
		//System.out.println(list);
		System.out.println("shown");
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		String jsonString = gson.toJson(list);
		response.getWriter().print(jsonString);
		System.out.println("shown requirements ids");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		requirementDAO.dataSource = this.dataSource;
		
		InputStreamReader reader = new InputStreamReader(request.getInputStream());
		BufferedReader br = new BufferedReader(reader);
		String jsonString = br.readLine();
		System.out.println(jsonString);
		
		response.getWriter().write("success");
		
		JSONObject jsonOb;
		String requesteddate="",closingdate="",mode="",domain="";
		int vacancies=0,minexp=0;
		try {
			jsonOb = new JSONObject(jsonString);
			requesteddate = jsonOb.getString("requesteddate");
			closingdate = jsonOb.getString("closingdate");
			mode = jsonOb.getString("mode");
			domain= jsonOb.getString("domain");
			vacancies= jsonOb.getInt("vacancies");
			minexp= jsonOb.getInt("experience");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
		}
		System.out.println(requesteddate);
		System.out.println(closingdate);
		System.out.println(mode);
		System.out.println(domain);
		System.out.println(vacancies);
		System.out.println(minexp);
		
		
		int res=requirementDAO.addRequirement(requesteddate, closingdate, domain, vacancies, minexp, mode);
		if(res>0)
		{
			String jstr = "success";
			Gson gson = new Gson();
			response.getWriter().print(gson.toJson(jstr));
			System.out.println("requirement added");
		}
	}

}
