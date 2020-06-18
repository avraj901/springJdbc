package com.nit.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
		StudentBO studentBO1 = null;
		studentBO1 = jt.queryForObject(STUDENT_GET_BYID, new BeanPropertyRowMapper<StudentBO>(StudentBO.class)
		, id);
		return studentBO1;
	}


}
