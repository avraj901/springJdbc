package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import com.nt.vo.EmployeeVO;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String INSERT_STUDENT_DETAILS="INSERT INTO employee_table(employee_name,employee_salary, employee_email, employee_gender)VALUES(?,?,?,?)";
	private DataSource datasource;

	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}
	@Override
	public int createEmployee(EmployeeVO employeeVO) throws SQLException {
           Connection con=null;
           PreparedStatement ps=null;
           int result = 0;
           try {
        	  
           con = datasource.getConnection();
           ps = con.prepareStatement(INSERT_STUDENT_DETAILS);
           ps.setString(1, employeeVO.getEmployeename());
           ps.setDouble(2, employeeVO.getEmployeesalary());
           ps.setString(3, employeeVO.getEmployeeemail());
           ps.setString(4, employeeVO.getEmployeegender());
           result = ps.executeUpdate();
           if(result>0) {
        	   System.out.println("Employee is inserted :: ");
           }
           }catch(Exception e) {
        	   e.printStackTrace();
           }finally {
        	   if(con !=null) {
        		   con.close();
        	   }
           }
		return result;
	}

	@Override
	public EmployeeVO getEmployeeDetails(String email) {
		// TODO Auto-generated method stub
		return null;
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
