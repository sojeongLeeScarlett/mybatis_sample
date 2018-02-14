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
	/*Student selectAllStudentByParam(String name,String email); //API는 파라미터 두개 못받음*/
	Student selectAllStudentByStudentWithAPI(Student student);
	Student selectAllStudentByMapWithAPI(Map<String, String> map);
	
	//ResultSet 처리방식 재정의
	Map<Integer, String> selectStudentForMap();
	
	
	Student selectStudentByNoForResultMapExtendsWithAPI(Student student);

	int insertStudentwithAPI(Student student);
	int insertEnumStudentWithAPI(Student student);
	
	int updateStudentWithAPI(Student student);
	int deleteStudentWithAPI(int id);
	
	//set
	int updateSetStudent(Student student);
	
}
