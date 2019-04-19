package com.hksoftworks.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hksoftworks.model.Reimbursement;

public interface ReimbursementService {

	List<Reimbursement> getAllReimbursements (HttpServletRequest request, HttpServletResponse response);
	Reimbursement createNewReimb(HttpServletRequest request, HttpServletResponse response);
	Reimbursement updateReimbStatus(HttpServletRequest request, HttpServletResponse response);
}
