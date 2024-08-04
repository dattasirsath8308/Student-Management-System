package com.datta.Services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.datta.Repository.StudentRepository;
import com.datta.Services.StudentService;
import com.datta.entity.Student;



@Service
public class StudentServiceImpl  implements StudentService{

	
	private StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}


	
	@Override
	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}



	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}



	@Override
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).get();
	}



	@Override
	public Student editStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}



	@Override
	public void deleteStudent(Long id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
		
	}

	
	
	
	
}
