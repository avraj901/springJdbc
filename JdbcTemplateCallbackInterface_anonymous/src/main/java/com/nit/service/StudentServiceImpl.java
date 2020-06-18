package com.nit.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.bo.StudentBO;
import com.nit.dao.StudentDAO;
import com.nit.dto.StudentDto;
@Service("studentService")
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentDAO studentDao;
	@Override
	public StudentDto fetchStudentByID(int number) {
		System.out.println("StudentServiceImpl.fetchStudentByID()");
        StudentBO bo=null;
        StudentDto dto=null;
        dto=new StudentDto();
		bo=studentDao.getStudentById(number);
         BeanUtils.copyProperties(bo, dto);
		return dto;
	}



}
