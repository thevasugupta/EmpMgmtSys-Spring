package emp.dao;

import emp.model.EmployeeMgmt;

public interface EmpDao {
	
	public void getEmpById(EmployeeMgmt employee);
	public void getAllEmp(EmployeeMgmt employee);
	public void deleteEmp(EmployeeMgmt employee);
	public void updateEmpSal(EmployeeMgmt employee);
	public void createEmp(EmployeeMgmt employee);
	
	

}
