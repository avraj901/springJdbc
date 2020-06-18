package com.nit.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nit.bo.StudentBO;

@Repository
public class StudentDAOImpl implements StudentDAO {
	private static final String STUDENT_GET_BYID = "SELECT sno, sname, saddress, savg FROM student WHERE sno=?";
	@Autowired
	private JdbcTemplate jt;

	@Override
	public StudentBO getStudentById(int id) {
		System.out.println("StudentDAOImpl");
		System.out.println("Student id ::" + id);
		StudentBO studentBO = null;
		studentBO = jt.queryForObject(STUDENT_GET_BYID, new RowMapper<StudentBO>() {

			@Override
			public StudentBO mapRow(ResultSet rs, int rowNum) throws SQLException {
                      StudentBO studentBO=null;
                      studentBO=new StudentBO();
                      studentBO.setSno(rs.getInt(1));
                      studentBO.setSname(rs.getString(2));
                      studentBO.setSaddress(rs.getString(3));
                      studentBO.setSavg(rs.getFloat(4));
				return studentBO;
			}//anonymous inner class
		}, id);
		return studentBO;
	}


}
