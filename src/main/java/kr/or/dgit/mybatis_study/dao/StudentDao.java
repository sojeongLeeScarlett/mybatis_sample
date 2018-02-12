package kr.or.dgit.mybatis_study.dao;

import java.util.List;

import kr.or.dgit.mybatis_study.dto.Student;

public interface StudentDao {

	
	Student selectStudentByNoWithAPI(Student student);
	List<Student> selectStudentByAllWithAPI();
	
	List<Student> selectStudentByAllForResultMapWithAPI();

	int insertStudentwithAPI(Student student);
	int updateStudentWithAPI(Student student);
	int deleteStudentWithAPI(int id);
	
}
