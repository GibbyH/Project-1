package com.hksoftworks.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.hksoftworks.JDBC.ConnectionManager;
import com.hksoftworks.JDBC.tables.EmployeeDao;
import com.hksoftworks.JDBC.tables.EmployeeDaoImpl;
import com.hksoftworks.beans.Employee;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final Logger log = Logger.getLogger(Login.class);
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = ConnectionManager.getConnection();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		EmployeeDao emp = new EmployeeDaoImpl();
		
		if (username == null || username == "" || password == null || password == "") {
			
			response.setContentType("text/plain");
			PrintWriter writing  = response.getWriter();
			writing.write("Username or password incorrect");
		} else {
			emp.getEmployeeByEmailAndPassword(username, password);
			response.sendRedirect("./homepagemanager.html");
		}	
		System.out.println(username + " : " + password);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
