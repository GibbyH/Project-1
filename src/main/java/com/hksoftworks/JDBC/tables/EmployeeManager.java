package com.hksoftworks.JDBC.tables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hksoftworks.JDBC.ConnectionManager;
import com.hksoftworks.JDBC.DBUtil;
import com.hksoftworks.beans.Employee;

public class EmployeeManager {
	
	private static Connection conn = ConnectionManager.getInstance().getConnection();

	public static void displayAllRows() throws SQLException {
		
		String sql = "SELECT emp_id, last_name, first_name, email, manager_id FROM employees";
		
		try (
//			Connection conn = DBUtil.getConnection();
			Statement stmt= conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
				){
			System.out.println("Employee table: ");
		
			while (rs.next()) {
				StringBuffer buffer = new StringBuffer();
				
				buffer.append("Employee " + rs.getInt("EMP_ID") + ": ");
				buffer.append(rs.getString("LAST_NAME") + ", ");
				buffer.append(rs.getString("FIRST_NAME") + ", ");
				buffer.append(rs.getString("EMAIL") + ", ");
				buffer.append(rs.getInt("MANAGER_ID"));
				
				System.out.println(buffer.toString());
			}
		}
	}
	
	public static Employee getRow(int empId) throws SQLException {
		
		String sql = "SELECT * FROM employees WHERE emp_id = ?";
		ResultSet rs = null;
		
		try(
//				Connection conn = DBUtil.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				){
			stmt.setInt(1, empId);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				Employee emp = new Employee();
				emp.setEmpId(empId);
				emp.setLastName(rs.getString("LAST_NAME"));
				emp.setFirstName(rs.getString("FIRST_NAME"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setManagerId(rs.getInt("MANAGER_ID"));
				return emp;
			} else {
				System.err.println("No rows found.");
				return null;
			}
		} catch (SQLException e) {
			System.err.println(e);
			return null;
		} finally {
			if (rs != null)
				rs.close();
		}
	}
	
	public static boolean insert(Employee emp) throws SQLException {
		
		String sql = "INSERT INTO employees (emp_id, last_name, first_name, email, pass, manager_id)"+
		"VALUES(?, ?, ?, ?, ?, ?)";
		
		try(
//				Connection conn = DBUtil.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				){
			stmt.setInt(1, emp.getEmpId());
			stmt.setString(2, emp.getLastName());
			stmt.setString(3, emp.getFirstName());
			stmt.setString(4, emp.getEmail());
			stmt.setString(5, emp.getPass());
			stmt.setInt(6, emp.getManagerId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		} finally {
			
		}
		return true;
		
	}
	
	public static boolean update(Employee emp) throws SQLException {
		String sql = "UPDATE employees " +
				"SET last_name = ?, first_name = ?, email = ?, pass = ?, manager_id = ? "+
				"WHERE emp_id = ?";
		
		try(
//				Connection conn = DBUtil.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				){
			stmt.setString(1, emp.getLastName());
			stmt.setString(2, emp.getFirstName());
			stmt.setString(3, emp.getEmail());
			stmt.setString(4, emp.getPass());
			stmt.setInt(5, emp.getManagerId());
			stmt.setInt(6, emp.getEmpId());
			
			int affected = stmt.executeUpdate();
			if(affected == 1)
				return true;
			else
				return false;			
			
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}
	
	public static boolean delete(int empId) throws SQLException {
		
		String sql = "DELETE FROM employees WHERE emp_id = ?";
		try(
//				Connection conn = DBUtil.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				){
			
			stmt.setInt(1, empId);
			int affected = stmt.executeUpdate();
			
			if(affected == 1)
				return true;
			else
				return false;			
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}
}
