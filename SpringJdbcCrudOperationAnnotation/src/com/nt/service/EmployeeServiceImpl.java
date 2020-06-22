package com.nt.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.EmployeeDAO;
import com.nt.vo.EmployeeVO;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public int insertEmployee(EmployeeVO employeeVO) throws SQLException {
		return employeeDAO.createEmployee(employeeVO);

	}

	@Override
	public EmployeeVO fetchEmployeeDetails(String email) {

		return employeeDAO.getEmployeeDetails(email);
	}

	@Override
	public void deleteEmployeeByName(String name) {
		employeeDAO.removeEmployeeByName(name);
	}

	@Override
	public void updateEmployeeByEmail(String email) {
		employeeDAO.updateEmployeeByEmail(email);
	}

	@Override
	public List<EmployeeVO> informationOfEmployeee(String name) {
		System.out.println("EmployeeServiceImpl");
		return employeeDAO.detailsOfEmployeee(name);
	}

}
