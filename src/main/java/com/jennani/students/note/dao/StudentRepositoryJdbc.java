package com.jennani.students.note.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.jennani.students.note.entities.Student;

@Component
public class StudentRepositoryJdbc implements DaoRepository<Student>{

	@Autowired
	private JdbcTemplate jdbcTemplate;


	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	final String SELECT_STUDENT_BY_ID = "select id, name, course, note from student where `id` = ?;";
	final String SELECT_ALL_STUDENTS = "select * from student;";
	final String INSERT_QUERY = "insert into student (name, course, note) VALUES  (?, ?, ?);";
	final String UPDATE_QUERY = "update student set name = ?, course =?, note = ? where `id` = ?;";
	final String DELETE_QUERY = "delete from student where id = ?;";
	
	public void insert(Student student) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(INSERT_QUERY, student.getName(), student.getCourse(), student.getNote());
	}

	public void update(Student student) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(UPDATE_QUERY, student.getName(), student.getCourse(), student.getNote(),student.getId());
		
	}

	public void delete(Student student) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(DELETE_QUERY, student.getId());
	}

	public List<Student> list() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(SELECT_ALL_STUDENTS, new ResultSetExtractor<List<Student>>() {

			public List<Student> extractData(ResultSet rs) throws SQLException {

				List<Student> students = new ArrayList<Student>();

				while (rs.next()) {

					Student student = new Student();
					
					student.setId(rs.getInt("id"));
					student.setName(rs.getString("name"));
					student.setCourse(rs.getString("course"));
					student.setNote(rs.getDouble("note"));
					students.add(student);

				}
				return students;
			}
		});
	}


	public Student getById(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(SELECT_STUDENT_BY_ID, new Object[] { id }, new ResultSetExtractor<Student>() {

			public Student extractData(ResultSet rs) throws SQLException {

				Student student = new Student();
				while (rs.next()) {
					student.setId(rs.getInt("id"));
					student.setName(rs.getString("name"));
					student.setCourse(rs.getString("course"));
					student.setNote(rs.getDouble("note"));
				}
				return student;
			}
		});
	}

}
