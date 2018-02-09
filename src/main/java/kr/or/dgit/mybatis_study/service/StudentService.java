package kr.or.dgit.mybatis_study.service;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_study.dao.StudentDao;
import kr.or.dgit.mybatis_study.dao.StudentDaoImpl;
import kr.or.dgit.mybatis_study.dto.Student;
import kr.or.dgit.mybatis_study.util.MyBatisSqlSessionFactory;

public class StudentService {
	public Student findStudentByNo(Student student) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			StudentDao studentDao = new StudentDaoImpl(sqlSession);
			return studentDao.selectStudentByNo(student);
		}
	}
}
