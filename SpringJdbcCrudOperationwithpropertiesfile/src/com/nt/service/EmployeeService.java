package com.nt.service;

import java.sql.SQLException;
import java.util.List;

import com.nt.vo.EmployeeVO;

public interface EmployeeService {

	public int insertEmployee(EmployeeVO employeeVO) throws SQLException;
	public EmployeeVO fetchEmployeeDetails(String email);
	public void deleteEmployeeByName(String name);
	public void updateEmployeeByEmail(String email);
	public List<EmployeeVO> informationOfEmployeee(String name);
}
