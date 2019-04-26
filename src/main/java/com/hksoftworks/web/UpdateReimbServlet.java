package com.hksoftworks.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hksoftworks.dao.ReimbursementDao;
import com.hksoftworks.dao.ReimbursementDaoImpl;
import com.hksoftworks.service.ReimburesmentServiceImpl;
import com.hksoftworks.service.ReimbursementService;

/**
 * Servlet implementation class UpdateReimbServlet
 */
public class UpdateReimbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ObjectMapper mapper = new ObjectMapper();
	ReimbursementService reimbServ = new ReimburesmentServiceImpl();
	ReimbursementDao dao = new ReimbursementDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateReimbServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String status = (String) request.getParameter("status");
		final int rqstNum = Integer.valueOf((String) request.getParameter("requestnum"));
		System.out.println("Status: " + status + " | RequestNumber" + rqstNum);
		if(status == "" || status== null ) 
			System.out.println("Invalid entries");
		else 
			dao.updateReimburseement(status, rqstNum);
		RequestDispatcher rd = request.getRequestDispatcher("/reimbursements.html");
		rd.forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
