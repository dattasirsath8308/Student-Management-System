package com.datta.Services;

import java.util.List;

import com.datta.entity.Student;

public interface StudentService {

	
	List<Student> getAllStudent();
	
	Student saveStudent(Student student);
	
	Student getStudentById(Long id);
	
	Student editStudent(Student student);
	
	void deleteStudent(Long id);
}
