package emp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import emp.config.EmpConfig;
import emp.dao.EmpDaoImpl;
import emp.model.EmployeeMgmt;

public class EmpMgmtSys {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(EmpConfig.class);
		
		EmployeeMgmt emp = new EmployeeMgmt();
		emp.setEmpId(1);
		emp.setEmpName("Vasu");
		
		EmpDaoImpl empImpl = context.getBean("daoImplementation",EmpDaoImpl.class);
		
		empImpl.deleteEmpbyName(emp);
	}

}
