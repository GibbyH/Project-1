package com.hksoftworks.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hksoftworks.dao.EmployeeDao;
import com.hksoftworks.dao.EmployeeDaoImpl;
import com.hksoftworks.model.Employee;

/**
 * Servlet implementation class GetEmpByIdServlet
 */
public class GetEmpByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEmpByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDao dao = new EmployeeDaoImpl();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
				
		int empId = Integer.valueOf(request.getParameter("emp_id"));
		//System.out.println(empId);
		System.out.println(empId);
		
		if(dao.getEmployeeById(empId) != null) {
			RequestDispatcher rd = request.getRequestDispatcher("/associatesinfo.html");
			rd.forward(request, response);
		} else {
			out.print("Invalid Employee Id Entered.");
			RequestDispatcher rd = request.getRequestDispatcher("/associatesinfo.html");
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
