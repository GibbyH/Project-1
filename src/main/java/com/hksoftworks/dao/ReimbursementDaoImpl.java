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
				reimbs.add(new Reimbursement(rs.getInt("REQUEST_NUM"), rs.getInt("EMP_ID"), rs.getDouble("AMOUNT"),
						rs.getDate("SUMBITTED"), rs.getString("STATUS")));
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
			return reimbs;
	}

	@Override
	public Reimbursement getReimbursementById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement createReimbursement(Reimbursement reimb) {
		try(Connection conn = ConnectionManager.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO reimbursements (REQUEST_NUM, " +
			"EMP_ID, AMOUNT, SUMBITTED, STATUS) VALUES(?, ?, ?, ?, ?)");
			
			//Set values of out insert statements
			stmt.setInt(1, reimb.getRequestNum());
			stmt.setInt(2, reimb.getEmpId());
			stmt.setDouble(3, reimb.getAmount());
			stmt.setDate(4, (Date) reimb.getSubmitted());
			stmt.setString(5, reimb.getStatus());
			
			
			// Execute the query determining the number of rows that where affected
			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected == 1)
				return reimb;
		} catch (SQLException e) {
			System.err.println(e);;
		}
		return reimb;
	}

	@Override
	public Reimbursement updatereimburseement(Reimbursement reimbToBeUpdated) {
		// TODO Auto-generated method stub
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
			PreparedStatement stmt = conn.prepareStatement("SELECT * from ");
			
			return reimbs;
		} catch (Exception e){
			
		}
		return null;
	}


}
