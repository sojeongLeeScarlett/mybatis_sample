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
	
	
	
	public int insertStudentWithAPI(Student student) {
		int res = -1;
		log.debug("insertStudentWithAPI()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			
			
			res = sqlSession.insert(namespace+"insertStudentWithAPI",student);
			sqlSession.commit();
					
		}
		return res;
	}
}
