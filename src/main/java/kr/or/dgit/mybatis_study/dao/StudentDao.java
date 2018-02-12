package kr.or.dgit.mybatis_study.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.mybatis_study.dto.Student;

public interface StudentDao {
	Student selectStudentByNo(Student student);
	List<Student> selectStudentByAll();
	
	List<Student> selectStudentByAllForResultMap();
	List<Map<String,Object>> selectStudentByAllForHashMap();
	
	int updateStudent(Student student);
	
	int insertStudent(Student student);
	
	int deleteStudent(int id);
	
}
