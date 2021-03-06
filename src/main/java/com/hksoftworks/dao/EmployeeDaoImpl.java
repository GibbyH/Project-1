package com.hksoftworks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hksoftworks.model.Employee;
import com.hksoftworks.util.ConnectionManager;

public class EmployeeDaoImpl implements EmployeeDao {
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> emps = new ArrayList<>();
		try (Connection conn = ConnectionManager.getConnection()){
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
			while (rs.next()) {
				emps.add(new Employee(rs.getInt("emp_id"), rs.getString("last_name"), rs.getString("first_name"),
						rs.getString("email"), rs.getString("pass"), rs.getInt("manager_id")));
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
			return emps;
	}
	
	private Employee extractEmployeeFromResultSet(ResultSet rs) throws SQLException {
		Employee emp = new Employee();
        emp.setEmpId(rs.getInt("emp_id"));
        emp.setLastName(rs.getString("last_name"));
        emp.setFirstName(rs.getString("first_name"));
        emp.setEmail(rs.getString("email"));
        emp.setPass(rs.getString("pass"));
        emp.setManagerId(rs.getInt("manager_id"));
        return emp;
	}

	@Override
	public Employee getEmployeeById(int id) {
		
		ResultSet rs = null;
		
		try(Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM employees WHERE emp_id = ?");)
		{
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				return extractEmployeeFromResultSet(rs);
			} else {
				System.err.println("No results found");
				return null;
			}
            
        } catch (SQLException ex) {
            System.err.println(ex);
            return null;
        } 
	}
	
	@Override
	public Employee createEmployee(Employee emp) {
		//Get connection to Database
		try(Connection conn = ConnectionManager.getConnection()){
			//Initialize inset statment
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO employees (emp_id, " +
			"last_name, first_name, email, pass, manager_id) VALUES(?, ?, ?, ?, ?, ?)");
			
			//Set values of out insert statements
			stmt.setInt(1, emp.getEmpId());
			stmt.setString(2, emp.getLastName());
			stmt.setString(3, emp.getFirstName());
			stmt.setString(4, emp.getEmail());
			stmt.setString(5, emp.getPass());
			stmt.setInt(6, emp.getManagerId());
			
			// Execute the query determining the number of rows that where affected
			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected == 1)
				return emp;
			else
				return null;
		} catch (SQLException e) {
			System.err.println("Sql state: " + e.getSQLState());
			System.err.println("Error code: " + e.getErrorCode());
			throw new RuntimeException("Failed to create employee");
		}
		
	}

	@Override
	public boolean updateEmployee(Employee empToBeUpdated) {
		
		try(Connection conn = ConnectionManager.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("Update employees Set last_name = ?, " +
					"first_name =?, email = ?, manager_id = ? Where emp_id = ?");
			
			stmt.setString(1, empToBeUpdated.getLastName());
			stmt.setString(2, empToBeUpdated.getFirstName());
			stmt.setString(3, empToBeUpdated.getEmail());
			stmt.setString(4, empToBeUpdated.getPass());
			stmt.setInt(5, empToBeUpdated.getManagerId());
			stmt.setInt(6, empToBeUpdated.getEmpId());
			
			System.out.println(empToBeUpdated.toString());
			
			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected == 1)
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			System.err.println("Sql state: " + e.getSQLState());
			System.err.println("Error code: " + e.getErrorCode());
			throw new RuntimeException("Failed to update employee");
		}
	}

	@Override
	public long deleteEmployee(Employee... empToBeDeleted) {
//		Employee emp = new Employee();
//		try(Connection conn = ConnectionManager.getConnection()){
//			Statement stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery("DELETE FROM employees WHERE emp_id = ?");
//			while(rs.next()) {
//				
//			}
//		}
		return (Long) null;
	}

	@Override
	public boolean getEmployeeByEmailAndPassword(String username, String password) {
		
		boolean status = false;
		try(Connection conn = ConnectionManager.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM EMPLOYEES WHERE EMAIL = ? and PASS = ?");
			
			stmt.setString(1, username);
			stmt.setString(2,  password);
			
			ResultSet rs = stmt.executeQuery();
			status = rs.next();
		} catch (Exception e) {
			System.err.println(e);
		}
		return status;
	}

	@Override
	public boolean isManager(Employee emp) {
		return false;
	}	
	
//	public static void main(String[] args) {
//		
//		EmployeeDaoImpl emp = new EmployeeDaoImpl();
//		
//		System.out.println(emp.getAllEmployees());
//	}
		
}
