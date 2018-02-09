package kr.or.dgit.mybatis_study.dao;

import java.util.List;

import kr.or.dgit.mybatis_study.dto.Student;

public interface StudentDao {

	
	Student selectStudentByNoWithAPI(Student student);
	List<Student> selectStudentByAllWithAPI();

	int insertStudentwithAPI(Student student);
}
