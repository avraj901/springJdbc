package com.nt.test;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.EmployeeService;
import com.nt.service.EmployeeServiceImpl;
import com.nt.vo.EmployeeVO;

public class EmployeeTest {

	public static void main(String[] args) throws SQLException {
		EmployeeService employeeService = null;
		EmployeeVO employeeVO = null;
		List<EmployeeVO> listemployee = null;
		employeeVO = new EmployeeVO();

		ApplicationContext context = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		employeeService = context.getBean("employeeService", EmployeeServiceImpl.class);
		/*
		 * employeeVO.setEmployeename("ramu"); employeeVO.setEmployeesalary(90000.00);
		 * employeeVO.setEmployeeemail("avraj901@gmail.com");
		 * employeeVO.setEmployeegender("MALE");
		 * employeeService.insertEmployee(employeeVO);
		 * System.out.println("Employee inserted in Database ");
		 */

		//employeeVO = employeeService.fetchEmployeeDetails("ram@gmail.com");
		//System.out.println("Employee Details by id :: "+employeeVO);
		
	    // employeeService.deleteEmployeeByName("ram");
		
		//employeeService.updateEmployeeByEmail("ram@gmail.com");
		System.out.println("line 37");
		
		listemployee = employeeService.informationOfEmployeee("avani");
		System.out.println(listemployee);
		for(EmployeeVO employee : listemployee)
			System.out.println(employee.getEmployeename()+"\t"+employee.getEmployeesalary()+"\t"+employee.getEmployeeemail()+"\t"+employee.getEmployeesalary());
	}
}
