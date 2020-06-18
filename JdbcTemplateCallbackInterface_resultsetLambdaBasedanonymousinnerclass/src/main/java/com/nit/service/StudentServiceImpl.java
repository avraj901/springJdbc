package com.nit.service;

import java.util.ArrayList;
import java.util.List;

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
	@Override
	public List<StudentDto> getStudentByAddress(String address) {
           List<StudentBO> studentBO=null;
           List<StudentDto> studentDto=new ArrayList();
           studentBO=studentDao.getStudentByAddress(address);
           studentBO.forEach(bo ->{
        	   StudentDto dto=new StudentDto();
        	   BeanUtils.copyProperties(bo, dto);
        	   studentDto.add(dto);
           });
		return studentDto;
	}
}
