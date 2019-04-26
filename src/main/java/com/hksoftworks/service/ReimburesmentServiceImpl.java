package com.hksoftworks.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hksoftworks.dao.ReimbursementDao;
import com.hksoftworks.dao.ReimbursementDaoImpl;
import com.hksoftworks.model.Reimbursement;

public class ReimburesmentServiceImpl implements ReimbursementService{
	
	private final ReimbursementDao dao = new ReimbursementDaoImpl();
	private final ObjectMapper mapper = new ObjectMapper();

	@Override
	public List<Reimbursement> getAllReimbursements(HttpServletRequest request, HttpServletResponse response) {
		
		return dao.getAllReimbursements();
	}

	@Override
	public Reimbursement createNewReimb(HttpServletRequest request, HttpServletResponse response) {
		try {
			Reimbursement reimb = mapper.readValue(request.getInputStream(), Reimbursement.class);
			return dao.createReimbursement(reimb);
		} catch (IOException e) {
			return null;
		}
	}

	@Override
	public boolean updateReimbStatus(HttpServletRequest request, HttpServletResponse response) {
		
			final String status = (String) request.getParameter("status");
			final int rqstNum = Integer.valueOf((String) request.getParameter("requestnum"));
			System.out.println("Status: " + status + " | RequestNumber" + rqstNum);
			if(status == "" || status== null ) 
				return dao.updateReimburseement(status, rqstNum);
			else 
				System.out.println("Invalid entries");
				return false;
		
	}

}
