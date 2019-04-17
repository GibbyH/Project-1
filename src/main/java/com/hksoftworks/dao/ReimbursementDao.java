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
	
	List<Reimbursement> getAllEmployees();
	Reimbursement getEmployeeById(int id);
	Reimbursement createEmployee(Reimbursement emp);
	Reimbursement updateEmployee(Reimbursement empToBeUpdated);
	long deleteEmployee(Reimbursement... empToBeDeleted);
}
