package com.nt.test;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.service.EmployeeMgmtService;
import com.nt.service.EmployeeMgmtServiceImpl;

public class Test {

	public static void main(String[] args) {

		EmployeeMgmtService service = null;
		ApplicationContext ctx = null;
		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		service = ctx.getBean("empService", EmployeeMgmtService.class);
		try {
			System.out.println("Test.main()");
			System.out.println("Emps count :: " + service.fetchEmployeeCount());
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}

		try {
			System.out.println("Emps Name :: " + service.fetchStudentNamebyId(1));
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		try {
			System.out.println("Emps Details  :: " + service.fetchEmployeeDetailsByNumber(1));
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		try {
			System.out.println("Emp Details :: " + service.fetchStudentDetailsByAddress("begumpet", "ameerpet"));
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		try {
			System.out.println(
					"Insert Employee Details :: " + service.registerStudent(5, "bani", "rani ki sarai", "azamgarh"));
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		try {
			int value = service.updateStudentName("raja");

			System.out.println(" Employee name is updated " + value);

		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		try {
			System.out.println("college : "+service.fireStudentByNumber(2, 4));
		}catch(DataAccessException dae) {
			dae.printStackTrace();
		}
	}

}
