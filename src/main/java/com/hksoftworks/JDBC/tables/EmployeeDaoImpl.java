package com.hksoftworks.JDBC.tables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.hksoftworks.JDBC.ConnectionManager;
import com.hksoftworks.beans.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> emps = new ArrayList();
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
		
		try(Connection conn = ConnectionManager.getConnection()){
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM employees WHERE emp_id = " + id);
			if(rs.next())
            {
               return extractEmployeeFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
		return null;
	}
	
	@Override
	public Employee getEmployeeByEmailAndPassword(String username, String password) {
		try(Connection conn = ConnectionManager.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM employees WHERE email = ? " +
					" and pass = ?");
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			if(rs.next())
            {
               return extractEmployeeFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
		return null;
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
		} catch (SQLException e) {
			System.err.println(e);;
		}
		return emp;
	}

	@Override
	public Employee updateEmployee(Employee empToBeUpdated) {
		
		try(Connection conn = ConnectionManager.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("UPDATE employees SET id = ?, last_name = ?, first_name = ?, " +
		"email = ?, pass = ?, manager id = ?");
			stmt.setInt(1, empToBeUpdated.getEmpId());
			stmt.setString(2, empToBeUpdated.getLastName());
			stmt.setString(3, empToBeUpdated.getFirstName());
			stmt.setString(4, empToBeUpdated.getEmail());
			stmt.setString(5, empToBeUpdated.getPass());
			stmt.setInt(6, empToBeUpdated.getManagerId());
			
			// Execute the query determining the number of rows that where affected
			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected == 1)
				return empToBeUpdated;

		} catch (SQLException e) {
			System.err.println(e);
		}
		return null;
		
	}

	@Override
	public long deleteEmployee(Employee... empToBeDeleted) {
//		try (Connection conn = ConnectionManager.getConnection()){
//	        Statement stmt = conn.createStatement();
//	        int i = stmt.executeUpdate("DELETE FROM employee WHERE id=" + empToBeDeleted);
//	      if(i == 1) {
//	    return empToBeDeleted;
//	      }
//	    } catch (SQLException ex) {
//	        ex.printStackTrace();
//	    }
//	    return empToBeDeleted;
		return (Long) null;
	}	
	
	public static void main(String[] args) {
		
		EmployeeDaoImpl emp = new EmployeeDaoImpl();
		
		System.out.println(emp.getEmployeeByEmailAndPassword("samus.aran@email.com", "password"));
	}
		
}
