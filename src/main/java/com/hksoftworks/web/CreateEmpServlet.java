package com.hksoftworks.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hksoftworks.service.EmployeeService;
import com.hksoftworks.service.EmployeeServiceImpl;


/**
 * Servlet implementation class CreateEmpServlet
 */
public class CreateEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ObjectMapper mapper = new ObjectMapper();
	private static final EmployeeService empServ = new EmployeeServiceImpl(); 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateEmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.getOutputStream().write(mapper.writeValueAsBytes(empServ.createEmployee(request, response)));
		RequestDispatcher rd = request.getRequestDispatcher("associatesinfo.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
