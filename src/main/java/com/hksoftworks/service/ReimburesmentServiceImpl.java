package com.hksoftworks.service;

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

}
