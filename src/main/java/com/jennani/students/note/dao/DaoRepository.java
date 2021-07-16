package com.jennani.students.note.dao;

import java.util.List;

import com.jennani.students.note.entities.Student;

public interface DaoRepository<T> {
	public void insert(T t);
	public void update(T t);
	public void delete(T t);
	public List<T> list();
	public Student getById(int id);
}
