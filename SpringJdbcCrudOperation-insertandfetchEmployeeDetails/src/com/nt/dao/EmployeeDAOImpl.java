package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.nt.vo.EmployeeVO;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String INSERT_STUDENT_DETAILS="INSERT INTO employee_table(employee_name,employee_salary, employee_email, employee_gender)VALUES(?,?,?,?)";
	private static final String GET_DETAILS_By_EMAIL="SELECT employee_name,employee_salary,employee_email,employee_gender FROM employee_table Where employee_email=? ";
	private DataSource datasource;
	private JdbcTemplate jdbcTemplate =null;

	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
		jdbcTemplate = new JdbcTemplate(datasource);
	}
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
		// TODO Auto-generated method stub

	}

	@Override
	public void updateEmployeeByEmail(String email) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<EmployeeVO> detailsOfEmployeee(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
