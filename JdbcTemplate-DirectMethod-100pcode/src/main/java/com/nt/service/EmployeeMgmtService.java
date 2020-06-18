package com.nt.service;

import java.util.List;
import java.util.Map;

public interface EmployeeMgmtService {

	public int fetchEmployeeCount();
	public String fetchStudentNamebyId(int number);
	public Map<String,Object> fetchEmployeeDetailsByNumber(int number);
	public List<Map<String,Object>> fetchStudentDetailsByAddress(String city, String address);
	public int registerStudent(int number, String name, String city,String address);
	public int updateStudentName(String name);
	public String fireStudentByNumber(int number, int number1);
}
