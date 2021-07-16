package com.jennani.students.note.service;

import java.util.List;

import com.jennani.students.note.entities.Student;

public interface StudentService {
	public void insert(Student student);
	public void update(Student student);
	public void delete(Student student);
	public List<Student> list();
	public Student getById(int id);
}
