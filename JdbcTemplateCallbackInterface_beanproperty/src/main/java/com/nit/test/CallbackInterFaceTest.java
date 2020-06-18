package com.nit.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nit.dto.StudentDto;
import com.nit.service.StudentService;
import com.nit.service.StudentServiceImpl;

public class CallbackInterFaceTest {

	public static void main(String[] args) {
		System.out.println("CallbackInterFaceTest.main()");
		ApplicationContext context = null;
		StudentService studentService = null;
		StudentDto studentDto = null;
		context = new ClassPathXmlApplicationContext("com/nit/cfgs/applicationContext.xml");
		studentService = context.getBean("studentService", StudentServiceImpl.class);
		try {
			studentDto = studentService.fetchStudentByID(1);
			System.out.println("Student Details :: " + studentDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
