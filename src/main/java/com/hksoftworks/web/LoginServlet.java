package com.hksoftworks.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hksoftworks.dao.EmployeeDao;
import com.hksoftworks.dao.EmployeeDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entered login servlet");
		EmployeeDao dao = new EmployeeDaoImpl();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String n = request.getParameter("username");
		String p = request.getParameter("password");
		System.out.println("Username: " + n + " | Password: " + p);
		
		if(dao.getEmployeeByEmailAndPassword(n, p)){
			RequestDispatcher rd = request.getRequestDispatcher("/homepagemanager.html");
			rd.forward(request, response);
		} 
		else {
			out.print("Sorry, Username or password error");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
