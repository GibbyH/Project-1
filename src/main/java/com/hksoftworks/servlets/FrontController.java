package com.hksoftworks.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final Logger log = Logger.getLogger(FrontController.class);
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("Front controller working");
		
		String uri = request.getRequestURI();
		String[] uriPieces = uri.split("/");
		String lastPiece = uriPieces[uriPieces.length - 1];
		String servletName = lastPiece.substring(0, lastPiece.length() - 3).toLowerCase();
		
		switch (servletName) {
		case "login":
			request.getRequestDispatcher("Login").forward(request, response);
			break;

		default:
			response.setContentType("text/plain");
			PrintWriter out = response.getWriter();
			out.write("Requested servlet doesn't exist.");
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
