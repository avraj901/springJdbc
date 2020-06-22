package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.vo.EmployeeVO;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String INSERT_STUDENT_DETAILS="INSERT INTO employee_table(employee_name,employee_salary, employee_email, employee_gender)VALUES(?,?,?,?)";
	private static final String GET_DETAILS_By_EMAIL="SELECT employee_name,employee_salary,employee_email,employee_gender FROM employee_table Where employee_email=? ";
	private static final String DELETE_EMPLOYEE_BY_NAME="DELETE FROM employee_table WHERE employee_name=?";
	private static final String UPDATE_EMPLOYEE_BY_EMAIl="UPDATE employee_table set employee_email='rajani@gmail.com' WHERE employee_email=?";
	private static final String GET_ALL_EMPLOYEE_DETAILS="SELECT employee_name, employee_salary, employee_email, employee_gender FROM employee_table WHERE employee_name=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
  
	
	@Override
	public int createEmployee(EmployeeVO employeeVO) throws SQLException {
           int executeUpdate = 0;
           String name=employeeVO.getEmployeename();
           Double salary=employeeVO.getEmployeesalary();
           String email = employeeVO.getEmployeeemail();
           String gender = employeeVO.getEmployeegender();
       executeUpdate = jdbcTemplate.update(INSERT_STUDENT_DETAILS, new Object[] {name, salary,email, gender, });
       System.out.println("executeUpdate value :: "+ executeUpdate);
		return executeUpdate;
	}

	@Override
	public EmployeeVO getEmployeeDetails(String email) {
           EmployeeVO employeeVO =null;
           employeeVO=jdbcTemplate.queryForObject(GET_DETAILS_By_EMAIL, new EmployeeVORowMapper(),email);
		return employeeVO;
	}

	@Override
	public void removeEmployeeByName(String name) {
		int result=0;
            result =  jdbcTemplate.update(DELETE_EMPLOYEE_BY_NAME, name);
		if(result==1) {
			System.out.println("Employee successfully deleted From database");
		}
		return;
	}

	@Override
	public void updateEmployeeByEmail(String email) {

		int employeeStatus=0;
		employeeStatus = jdbcTemplate.update(UPDATE_EMPLOYEE_BY_EMAIl, email); 
		if(employeeStatus==1) {
			System.out.println("Employee Status is updated :");
		}
	}

	@Override
	public List<EmployeeVO> detailsOfEmployeee(String name) {
		System.out.println("EmployeeDAOImpl");
		List<EmployeeVO> employeeVO=null;
		employeeVO = jdbcTemplate.query(GET_ALL_EMPLOYEE_DETAILS, new EmployeeVORowMapper(), name);
		return employeeVO;
	}

}
