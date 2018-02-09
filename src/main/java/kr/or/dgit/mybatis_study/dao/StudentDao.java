package kr.or.dgit.mybatis_study.dao;

import kr.or.dgit.mybatis_study.dto.Student;

public interface StudentDao {
	Student selectStudentByNo(Student student);
	
}
