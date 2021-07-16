package com.jennani.students.note.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jennani.students.note.dao.DaoRepository;
import com.jennani.students.note.entities.Student;

@Component
public class StudentServiceImpl implements StudentService{

	@Autowired
	DaoRepository<Student> studentRepository;
	
	public void insert(Student student) {
		// TODO Auto-generated method stub
		studentRepository.insert(student);
	}

	public void update(Student student) {
		// TODO Auto-generated method stub
		studentRepository.update(student);
	}

	public void delete(Student student) {
		// TODO Auto-generated method stub
		studentRepository.delete(student);
	}

	public List<Student> list() {
		// TODO Auto-generated method stub
		return studentRepository.list();
	}

	public Student getById(int id) {
		// TODO Auto-generated method stub
		return studentRepository.getById(id);
	}

}
