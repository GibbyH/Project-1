package com.hksoftworks.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.hksoftworks.model.Employee;
import com.hksoftworks.model.Reimbursement;
import com.hksoftworks.util.ConnectionManager;

public interface ReimbursementDao {
	
	List<Reimbursement> getAllReimbursements();
	Reimbursement getReimbursementById(int id);
	Reimbursement createReimbursement(Reimbursement reimb);
	Reimbursement updatereimburseement(Reimbursement reimbToBeUpdated);
	long deleteReimbursement(Reimbursement... reimbToBeDeleted);
}
