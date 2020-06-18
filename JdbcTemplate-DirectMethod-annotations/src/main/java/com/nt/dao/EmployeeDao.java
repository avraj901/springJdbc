package com.nt.dao;

import java.util.List;
import java.util.Map;

public interface EmployeeDao {

	public int fetEmpsCount();
	public String fetchEmployeeNameById(int number);
	public Map<String, Object> fetchEmployeeDetailsByNumber(int number);
	public List<Map<String,Object>> fetchStudentDeatilsByAddress(String city, String address);
	public int registerStudent(int number, String name, String city, String address);
	public int updateStudentName(String name);
	public int fireStudentByRange(int start, int end);
}
