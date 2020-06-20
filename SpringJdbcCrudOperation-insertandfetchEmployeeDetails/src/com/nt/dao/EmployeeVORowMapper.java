package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nt.vo.EmployeeVO;

public class EmployeeVORowMapper implements RowMapper<EmployeeVO> {

	@Override
	public EmployeeVO mapRow(ResultSet rs, int rownum) throws SQLException {
		EmployeeVO employeeVO = new EmployeeVO();
		employeeVO.setEmployeename(rs.getString("employee_name"));
		employeeVO.setEmployeesalary(rs.getDouble("employee_salary"));
		employeeVO.setEmployeeemail(rs.getString("employee_email"));
		employeeVO.setEmployeegender(rs.getString("employee_gender"));
		return employeeVO;
	}

}
