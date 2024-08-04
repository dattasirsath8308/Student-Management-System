package com.datta.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.datta.Services.StudentService;
import com.datta.entity.Student;

@Controller
public class StudentController {

	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	
//	handler method to handle list student and return and view 
	
	@GetMapping("/students")
	public String studentList(Model m)
	{
		m.addAttribute("students",studentService.getAllStudent());
		return "students";
	}
	

	
	@GetMapping("/students/new")
	public String createStudentform(Model m)
	{
		Student s = new Student();
		m.addAttribute("student",s);
		
		return "create_student"; 
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student")Student student)
	{
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	
	@GetMapping("/students/edit/{id}")
	public String editStudent(@PathVariable Long id, Model m)
	{
		m.addAttribute("student",studentService.getStudentById(id));
		
		return "edit_student";
	}
	

	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model m) {
	    // Get Student From Database
	    Student existingStudent = studentService.getStudentById(id);
	    existingStudent.setId(id);
	    existingStudent.setFirstName(student.getFirstName());
	    existingStudent.setLastName(student.getLastName());
	    existingStudent.setEmail(student.getEmail());

	    // Save updated Student
	    studentService.editStudent(existingStudent);
	    return "redirect:/students";
	}

	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id)
	{
		studentService.deleteStudent(id);
	    return "redirect:/students";

	}
	
	
	
}
