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
	
	public Student findStudentByNoWithAPI(Student student) {
		log.debug("selectStudentByNoWithAPI()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			
			return sqlSession.selectOne(namespace+"selectStudentByNoWithAPI", student);
		}
	}
	
	public List<Student> findStudentByAllWithAPI() {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			log.debug("selectStudentByAllWithAPI()");
			return sqlSession.selectList(namespace+"selectStudentByAllWithAPI");
		}
	}
	
	public int InsertStudent(Student student) {
		int res = -1;
		log.debug("insertStudent()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			res = studentDao.insertStudent(student);
			sqlSession.commit();
					
		}
		return res;
	}
	public int InsertStudentWithAPI(Student student) {
		int res = -1;
		log.debug("insertStudentwithAPI()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			
			
			res = sqlSession.insert(namespace+"insertStudentwithAPI",student);
			sqlSession.commit();
					
		}
		return res;
	}
}
