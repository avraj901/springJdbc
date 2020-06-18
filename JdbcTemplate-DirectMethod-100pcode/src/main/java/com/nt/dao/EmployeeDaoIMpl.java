package com.nt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("empDao")
public class EmployeeDaoIMpl implements EmployeeDao {

	private static final String GET_EMPS_COUNT = "SELECT COUNT(*) FROM college.Student";
	private static final String GET_EMPS_NAME = "SELECT student_name FROM college.Student WHERE number=?";
	private static final String GET_EMPS_DETAILS = "SELECT student_name, city, address FROM college.Student WHERE number=?";
	private static final String GET_EMPS_DETAILSBYADDRESS = "SELECT student_name, city, address FROM college.Student WHERE address IN (?,?)";
	private static final String INSERT_STUDENT_DETAILS = "INSERT INTO college.Student(number,student_name,city,address)VALUES(?,?,?,?)";
	private static final String UPDATE_STUDENT_DETAILS = "UPDATE college.Student SET student_name='avani' WHERE student_name=?";
	private static final String DELETE_STUDENT = "DELETE FROM college.Student WHERE number>=? AND number<=?";
	@Autowired
	private JdbcTemplate jt;

	public int fetEmpsCount() {
		System.out.println("EmployeeDaoIMpl");
		int count = 0;
		count = jt.queryForObject(GET_EMPS_COUNT, Integer.class);
		System.out.println("count value is ::" + count);
		return count;
	}

	public String fetchEmployeeNameById(int studentNumber) {
		String name = null;
		name = jt.queryForObject(GET_EMPS_NAME, String.class, studentNumber);
		return name;
	}

	public Map<String, Object> fetchEmployeeDetailsByNumber(int number) {
		Map<String, Object> map = null;
		map = jt.queryForMap(GET_EMPS_DETAILS, number);
		return map;
	}

	public List<Map<String, Object>> fetchStudentDeatilsByAddress(String city, String address) {
		List<Map<String, Object>> listStudents = null;
		listStudents = jt.queryForList(GET_EMPS_DETAILSBYADDRESS, city, address);
		return listStudents;
	}

	public int registerStudent(int number, String name, String city, String address) {
		int insertrow = 0;
		insertrow = jt.update(INSERT_STUDENT_DETAILS, number, name, city, address);
		return insertrow;
	}

	public int updateStudentName(String name) {
		int updateStudentName = 0;
		updateStudentName = jt.update(UPDATE_STUDENT_DETAILS, name);
		return updateStudentName;
	}

	public int fireStudentByRange(int start, int end) {
		int count = 0;
		count = jt.update(DELETE_STUDENT, start, end);
		return count;
	}

}
