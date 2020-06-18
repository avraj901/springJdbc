package com.nit.dao;

import java.util.List;

import com.nit.bo.StudentBO;

public interface StudentDAO {

	public StudentBO getStudentById(int id);
	public List<StudentBO> getStudentByAddress(String address);
}
