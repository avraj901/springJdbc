package com.nit.service;

import java.util.List;

import com.nit.dto.StudentDto;

public interface StudentService {

	public StudentDto fetchStudentByID(int number);
	public List<StudentDto> getStudentByAddress(String address);
}
