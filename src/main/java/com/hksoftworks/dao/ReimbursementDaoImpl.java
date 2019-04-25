package com.hksoftworks.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;

import com.hksoftworks.model.Reimbursement;
import com.hksoftworks.util.ConnectionManager;

public class ReimbursementDaoImpl implements ReimbursementDao {

	@Override
	public List<Reimbursement> getAllReimbursements() {
		List<Reimbursement> reimbs = new ArrayList<Reimbursement>();
		try(Connection conn = ConnectionManager.getConnection()){
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from reimbursements");
			while(rs.next())
				reimbs.add(new Reimbursement(rs.getInt("REQUEST_NUM"), rs.getInt("EMP_ID"), rs.getString("REASON"), 
						rs.getDouble("AMOUNT"), rs.getString("STATUS"), rs.getInt("MANAGER_ID")));
			return reimbs;
		} catch (SQLException e) {
			System.err.println("Sql state: " + e.getSQLState());
			System.err.println("Error code: " + e.getErrorCode());
			throw new RuntimeException("Failed to get all reimbursements");
		}
	}

	@Override
	public Reimbursement createReimbursement(Reimbursement reimb) {
		try (Connection conn = ConnectionManager.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("insert into reimbursements (request_num, emp_id, reason, amount) values(?, ?, ?, ?)");
			stmt.setInt(1, reimb.getRequestNum());
			stmt.setInt(2, reimb.getEmpId());
			stmt.setString(3, reimb.getReason());
			stmt.setDouble(4, reimb.getAmount());
			
			int rowsaffected = stmt.executeUpdate();
			if(rowsaffected == 1)
				return reimb;
			else
				return null;
		} catch (SQLException e) {
			System.err.println("Sql state: " + e.getSQLState());
			System.err.println("Error code: " + e.getErrorCode());
			throw new RuntimeException("Failed to create reimbusement");
		}
	}

	@Override
	public Reimbursement updateReimburseement(Reimbursement reimbToBeUpdated) {
		return null;
	}
	
	

	

}
