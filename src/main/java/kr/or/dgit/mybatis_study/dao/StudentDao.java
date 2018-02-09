package kr.or.dgit.mybatis_study.dao;

import java.util.List;

import kr.or.dgit.mybatis_study.dto.Student;

public interface StudentDao {
	Student selectStudentByNo(Student student);
	List<Student> selectStudentByAll();
	
	int updateStudent(Student student);
	
	int insertStudent(Student student);
	
	int deleteStudent(int id);
	
}
