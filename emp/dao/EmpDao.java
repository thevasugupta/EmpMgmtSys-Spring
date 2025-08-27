package emp.dao;

import emp.model.EmployeeMgmt;

public interface EmpDao {
	
	public void getEmpById(EmployeeMgmt employee);
	public void getAllEmp(EmployeeMgmt employee);
	public void deleteEmpbyId(EmployeeMgmt employee);
	public void deleteEmpbyName(EmployeeMgmt employee);
	public void updateEmpSal(EmployeeMgmt employee);
	public void createEmp(EmployeeMgmt employee);
	
	

}
