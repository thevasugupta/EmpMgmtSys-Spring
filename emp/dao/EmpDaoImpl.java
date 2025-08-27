package emp.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import emp.model.EmployeeMgmt;

public class EmpDaoImpl implements EmpDao {
	
	JdbcTemplate template;
	
	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	private String url = "jdbc:mysql://localhost:3306/advjava?useSSL=false";

    private String username = "root";
    private String password = "sql_qwerty";
    
	@Override
	public void getEmpById(EmployeeMgmt employee) {
		String query = "SELECT * FROM EMPLOYEES WHERE empId=?";
	    
	    List<EmployeeMgmt> employees = template.query(query, new Object[]{employee.getEmpId()}, (rs, rowNum) -> {
	        EmployeeMgmt e = new EmployeeMgmt();
	        e.setEmpId(rs.getInt("empId"));
	        e.setEmpName(rs.getString("empName"));
	        e.setEmpSal(rs.getDouble("empSal"));
	        e.setEmpAddress(rs.getString("empAddress"));
	        return e;
	    });

	    if (employees.isEmpty()) {
	        System.out.println("No employee found with ID: " + employee.getEmpId());
	    } else {
		    System.out.println("Displaying Records by ID:");
	        for (EmployeeMgmt e : employees) {
	            System.out.println("[ID: " + e.getEmpId() + 
	                               "], [Name: " + e.getEmpName() + 
	                               "], [Salary: " + e.getEmpSal() + 
	                               "], [Address: " + e.getEmpAddress() + "]");
	        }
	    }
		
	}

	@Override
	public void getAllEmp(EmployeeMgmt employee) {
		String query = "SELECT * FROM EMPLOYEES";

	    List<EmployeeMgmt> employees = template.query(query, (rs, rowNum) -> {
	        EmployeeMgmt e = new EmployeeMgmt();
	        e.setEmpId(rs.getInt("empId"));
	        e.setEmpName(rs.getString("empName"));
	        e.setEmpSal(rs.getDouble("empSal"));
	        e.setEmpAddress(rs.getString("empAddress"));
	        return e;
	    });

	    System.out.println("Displaying Records:");
	    for (EmployeeMgmt e : employees) {
	        System.out.println("ID: " + e.getEmpId() + 
	                           ", Name: " + e.getEmpName() + 
	                           ", Salary: " + e.getEmpSal() + 
	                           ", Address: " + e.getEmpAddress());
	    }
		
	}

	@Override
	public void deleteEmp(EmployeeMgmt employee) {
		String query = "DELETE FROM EMPLOYEES WHERE empId=?";
	    int rows = template.update(query, employee.getEmpId());
	    if (rows > 0) {
	        System.out.println("Employee " + employee.getEmpId() + " deleted successfully!");
	    } else {
	        System.out.println("No employee found with ID " + employee.getEmpId());
	    }
		
	}

	@Override
	public void updateEmpSal(EmployeeMgmt employee) {
		String query = "UPDATE EMPLOYEES "
				+ "SET empSal=? "
				+ "WHERE empId=?";
		
		template.update(query, employee.getEmpSal(),employee.getEmpId());
		System.out.println("Salary of Employee " + employee.getEmpId() + " updated successfully!");
		
	}

	@Override
	public void createEmp(EmployeeMgmt employee) {
		String query = "INSERT INTO EMPLOYEES (empId,empName,empSal,empAddress) VALUES (?,?,?,?)";
		template.update(query,employee.getEmpId(),employee.getEmpName(),employee.getEmpSal(),employee.getEmpAddress());
		 System.out.println("New Employee Created : ("+employee.getEmpId()+","+employee.getEmpName()+")");
	}
	
	

}
