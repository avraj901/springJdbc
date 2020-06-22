package com.nt.dao;

import java.sql.SQLException;
import java.util.List;

import com.nt.vo.EmployeeVO;

public interface EmployeeDAO {
	
	public int createEmployee(EmployeeVO employeeVO) throws SQLException;
	public EmployeeVO getEmployeeDetails(String email);
	public void removeEmployeeByName(String name);
	public void updateEmployeeByEmail(String email);
	public List<EmployeeVO> detailsOfEmployeee(String name);

}
