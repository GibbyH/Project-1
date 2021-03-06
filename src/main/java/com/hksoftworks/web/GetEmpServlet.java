package com.hksoftworks.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hksoftworks.service.EmployeeService;
import com.hksoftworks.service.EmployeeServiceImpl;

/**
 * Servlet implementation class GetEmpServlet
 */
public class GetEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ObjectMapper mapper = new ObjectMapper();
	EmployeeService empServ = new EmployeeServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("Entering GetEmpServlet");
		response.setContentType("application/json");
		response.getOutputStream().write(mapper.writeValueAsBytes(empServ.getAllEmployees(request, response)));
//		System.out.println("Resoponse sent succesfully!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
}
