package com.nit.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nit.bo.StudentBO;

@Repository
public class StudentDAOImpl implements StudentDAO {

	private static final String STUDENT_GET_BYID = "SELECT sno, sname, saddress, savg FROM student WHERE sno=?";
	private static final String GET_STUDENT_BY_ADDRESS = "SELECT sno, sname, saddress, savg FROM student WHERE saddress=?";
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
				StudentBO studentBO = null;
				studentBO = new StudentBO();
				studentBO.setSno(rs.getInt(1));
				studentBO.setSname(rs.getString(2));
				studentBO.setSaddress(rs.getString(3));
				studentBO.setSavg(rs.getFloat(4));
				return studentBO;
			}// anonymous inner class
		}, id);
		return studentBO;
	}

	@Override
	public List<StudentBO> getStudentByAddress(String address) {
		List<StudentBO> studentBO1 = null;
		studentBO1 = jt.query(GET_STUDENT_BY_ADDRESS,
				rs ->{
				List<StudentBO> studentBO = null;
				studentBO = new ArrayList<StudentBO>();
				StudentBO bo = null;
				while (rs.next()) {
					bo = new StudentBO();
					bo.setSno(rs.getInt(1));
					bo.setSname(rs.getString(2));
					bo.setSaddress(rs.getString(3));
					bo.setSavg(rs.getFloat(4));
					studentBO.add(bo);
				}
				return studentBO;
			
		}, address);
		return studentBO1;

	}
}