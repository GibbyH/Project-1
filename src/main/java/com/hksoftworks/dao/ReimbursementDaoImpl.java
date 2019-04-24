package com.hksoftworks.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

 
import com.hksoftworks.model.Reimbursement;
import com.hksoftworks.util.ConnectionManager;

public class ReimbursementDaoImpl implements ReimbursementDao {
	
	

	@Override
	public List<Reimbursement> getAllReimbursements() {
		List<Reimbursement> reimbs = new ArrayList<>();
		try (Connection conn = ConnectionManager.getConnection()){
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM reimbursements");
			while (rs.next()) {
				reimbs.add(new Reimbursement(rs.getInt("REQUEST_NUM"), rs.getInt("EMP_ID"), rs.getString("reason"),
						rs.getDouble("AMOUNT"),	rs.getInt("manager_id"), rs.getString("STATUS")));
			}
			return reimbs;
		} catch (SQLException e) {
			System.err.println(e);
		}
		return null;
	}

	@Override
	public Reimbursement getReimbursementById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement createReimbursement(Reimbursement reimb) {
		
		return null;
	}

	@Override
	public Reimbursement updatereimburseement(Reimbursement reimbToBeUpdated) {
		
		return null;
	}

	@Override
	public long deleteReimbursement(Reimbursement... reimbToBeDeleted) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Reimbursement> getAllReimbursements(String email) {
		List<Reimbursement> reimbs = new ArrayList<Reimbursement>();
		try(Connection conn = ConnectionManager.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("SELECT * from reimbursements");
			
			
			return reimbs;
		} catch (Exception e){
			
		}
		return null;
	}

	@Override
	public Reimbursement getReimbByEmpId(int id) {
		
		return null;
	}


}
