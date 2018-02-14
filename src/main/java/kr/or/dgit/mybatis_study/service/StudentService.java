package kr.or.dgit.mybatis_study.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_study.dao.StudentDao;
import kr.or.dgit.mybatis_study.dto.Student;
import kr.or.dgit.mybatis_study.util.MyBatisSqlSessionFactory;

public class StudentService {
	private static final Log log = LogFactory.getLog(StudentService.class);
	

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
	
	public int insertEnumStudent(Student student) {
		int res = -1;
		log.debug("insertEnumStudent()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			res = studentDao.insertEnumStudent(student);
			sqlSession.commit();
					
		}
		return res;
	}
	
	
	public int  updateStudent(Student student) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();
		
		log.debug("updateStudent()");
		try{	
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			int res = studentDao.updateStudent(student);
			sqlSession.commit();
			return res;	
		}catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException(e.getCause());
		}finally {
			sqlSession.close();
			
		}
		
	}
	
	public int deleteStudent(int id) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();
		
		log.debug("deleteStudent()");
		try{	
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			int res = studentDao.deleteStudent(id);
			sqlSession.commit();
			return res;	
		}catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException(e.getCause());
		}finally {
			sqlSession.close();
			
		}
		
	}
	
	public List<Student> selectStudentByAllForResultMap(){
		log.debug("selectStudentByAllForResultMap()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectStudentByAllForResultMap();
		}
		
	}
	public List<Map<String,Object>> selectStudentByAllForHashMap(){
		log.debug("selectStudentByAllForHashMap()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectStudentByAllForHashMap();
		}
	}
	
	public Student selectStudentByNoForResultMapExtends(Student student) {
		log.debug("selectStudentByNoForResultMapExtends()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectStudentByNoForResultMapExtends(student);
		}
	}
	
	public Student selectStudentByNoAssociation(Student student) {
		log.debug("selectStudentByNoForResultMapExtends()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectStudentByNoAssociation(student);
		}
	}
	
	public Student selectAllStudentByParam(String name,String email) {
		log.debug("selectAllStudentByParam()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectAllStudentByParam(name,email);
		}
	}
	public Student selectAllStudentByStudent(Student student) {
		log.debug("selectAllStudentByStudent()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectAllStudentByStudent(student);
		}
	}
	public Student selectAllStudentByMap(Map<String, String> map) {
		log.debug("selectAllStudentByMap()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.selectAllStudentByMap(map);
		}
	}
	
	

}
