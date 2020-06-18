package com.nt.service;

import java.util.List;
import java.util.Map;

import com.nt.dao.EmployeeDaoIMpl;

public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {

	private EmployeeDaoIMpl empDao;

	public EmployeeMgmtServiceImpl(EmployeeDaoIMpl empDao) {
		System.out.println("EmployeeMgmtServiceImpl - 1 param constructor");
		this.empDao = empDao;

	}

	public int fetchEmployeeCount() {
		System.out.println("EmployeeMgmtServiceImpl");
		int count = 0;
		count = empDao.fetEmpsCount();
		return count;
	}

	public String fetchStudentNamebyId(int number) {
		String name = null;
		name = empDao.fetchEmployeeNameById(number);
		return name;
	}

	public Map<String, Object> fetchEmployeeDetailsByNumber(int number) {
		Map<String, Object> map = null;
		map = empDao.fetchEmployeeDetailsByNumber(number);
		return map;
	}

	public List<Map<String, Object>> fetchStudentDetailsByAddress(String city, String address) {
		List<Map<String, Object>> listStudent = null;
		listStudent = empDao.fetchStudentDeatilsByAddress(city, address);
		return listStudent;
	}

	public int registerStudent(int number, String name, String city, String address) {
		int insertrow = 0;
		insertrow = empDao.registerStudent(number, name, city, address);
		return insertrow;
	}

	public int updateStudentName(String name) {
		int updatedNameValue = 0;
		updatedNameValue = empDao.updateStudentName(name);
		return 0;
	}

	public String fireStudentByNumber(int number, int number1) {
		int count = 0;
		count = empDao.fireStudentByRange(number, number1);
		return count + "no. of student are deleted";
	}

}
