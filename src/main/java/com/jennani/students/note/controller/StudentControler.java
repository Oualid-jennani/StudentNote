package com.jennani.students.note.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jennani.students.note.entities.Student;
import com.jennani.students.note.service.StudentService;

@Controller
@RequestMapping("")
public class StudentControler {

	@Autowired
	StudentService studentService;
	
	@GetMapping("/list")

	public String index(Model model) {

		model.addAttribute("ListStudents", studentService.list());

		return "ListStudents";
	}

	@GetMapping("/new")
	public String AddStudent(Model model) {

		Student student = new Student();

		model.addAttribute("student", student);

		return "NewStudent";
	}

	@PostMapping("/save")
	public String SaveStudent(@ModelAttribute Student student) {

		studentService.insert(student);

		return "redirect:/student/list";
	}

	@GetMapping("/update/{id}")
	public String UpdateStudent(@PathVariable(value = "id") int id, Model model)

	{
		Student student = studentService.getById(id);

		model.addAttribute("student", student);

		return "UpdateStudent";
	}

	@GetMapping("/delete/{id}")
	public String DeleteStudent(@PathVariable int id) {

		Student student = studentService.getById(id);

		studentService.delete(student);

		return "redirect:/student/list";

	}
	
}
