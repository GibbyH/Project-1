package com.hksoftworks.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hksoftworks.service.ReimburesmentServiceImpl;
import com.hksoftworks.service.ReimbursementService;

/**
 * Servlet implementation class CreateReimbServlet
 */
public class CreateReimbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ObjectMapper mapper = new ObjectMapper();
	ReimbursementService reimbServ = new ReimburesmentServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateReimbServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.getOutputStream().write(mapper.writeValueAsBytes(reimbServ.createNewReimb(request, response)));
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
