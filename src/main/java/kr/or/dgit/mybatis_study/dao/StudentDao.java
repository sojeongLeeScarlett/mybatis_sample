package kr.or.dgit.mybatis_study.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.mybatis_study.dto.Student;

public interface StudentDao {

	
	Student selectStudentByNoWithAPI(Student student);
	List<Student> selectStudentByAllWithAPI();
	
	List<Student> selectStudentByAllForResultMapWithAPI();
	List<Map<String, Object>> selectStudentByAllForHashMapWithAPI();
	Student selectStudentByNoAssociationWithAPI(Student student);
	
	
	Student selectStudentByNoForResultMapExtendsWithAPI(Student student);

	int insertStudentwithAPI(Student student);
	int insertEnumStudentWithAPI(Student student);
	
	int updateStudentWithAPI(Student student);
	int deleteStudentWithAPI(int id);
	
}
