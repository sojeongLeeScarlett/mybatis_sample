package kr.or.dgit.mybatis_study.service;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_study.dao.StudentDao;

import kr.or.dgit.mybatis_study.dto.Student;
import kr.or.dgit.mybatis_study.util.MyBatisSqlSessionFactory;

public class StudentService {
	private static final Log log = LogFactory.getLog(StudentService.class);
	private String namespace ="kr.or.dgit.mybatis_study.dao.StudentDao.";

	public Student findStudentByNo(Student student) {
		log.debug("selectStudentByNo");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectStudentByNo(student);
		}
	}
	
	public List<Student> findStudentByAll() {
		log.debug("selectStudentByAll()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectStudentByAll();
		}
	}
	

	
	public int insertStudent(Student student) {
		int res = -1;
		log.debug("insertStudent()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			res = studentDao.insertStudent(student);
			sqlSession.commit();
					
		}
		return res;
	}

}
