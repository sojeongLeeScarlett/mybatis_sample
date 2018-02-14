package kr.or.dgit.mybatis_study.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
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
	
	public List<Student> selectStudentByAllForResultMapWithAPI(){
		log.debug("selectStudentByAllForResultMapWithAPI()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			
			return sqlSession.selectList(namespace+"selectStudentByAllForResultMapWithAPI");
		}
	}
	
	public List<Map<String, Object>> selectStudentByAllForHashMapWithAPI(){
		log.debug("selectStudentByAllForHashMapWithAPI()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			
			return sqlSession.selectList(namespace+"selectStudentByAllForHashMapWithAPI");
		}
	}
	
	public Student selectStudentByNoForResultMapExtendsWithAPI(Student student) {
		log.debug("selectStudentByNoForResultMapExtendsWithAPI()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			
			return sqlSession.selectOne(namespace+"selectStudentByNoForResultMapExtendsWithAPI", student);
		}
	}
	
	public Student selectStudentByNoAssociationWithAPI(Student student) {
		log.debug("selectStudentByNoAssociationWithAPI()");
try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			
			return sqlSession.selectOne(namespace+"selectStudentByNoAssociationWithAPI", student);
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
	public int insertEnumStudentWithAPI(Student student) {
		int res = -1;
		log.debug("insertEnumStudentWithAPI()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			
			
			res = sqlSession.insert(namespace+"insertEnumStudentWithAPI",student);
			sqlSession.commit();
					
		}
		return res;
	}
	
	
	public int  updateStudentWithAPI(Student student) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();
		log.debug("updateStudentWithAPI()");
		try{	
			
			int res = sqlSession.update(namespace+"updateStudentWithAPI", student);
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
	
	public int deleteStudentWithAPI(int id) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();
		log.debug("deleteStudentWithAPI()");
		try{	
			
			int res = sqlSession.delete(namespace+"deleteStudentWithAPI", id);
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
	
	public Student selectAllStudentByStudentWithAPI(Student student) {
		log.debug("selectAllStudentByStudentWithAPI()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			return sqlSession.selectOne(namespace+"selectAllStudentByStudentWithAPI", student);
		}
		
	}
	public Student selectAllStudentByMapWithAPI(Map<String, String> map) {
		log.debug("selectAllStudentByMapWithAPI()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			
			return sqlSession.selectOne(namespace+"selectAllStudentByMapWithAPI", map);
		}
	}
	
	
	public Map<Integer, String> selectStudentForMap(){
		log.debug("selectStudentForMap()");
		Map<Integer, String> map = new HashMap<>();
		ResultHandler<Student> resultHandler = new ResultHandler<Student>() {
			
			@Override
			public void handleResult(ResultContext<? extends Student> resultContext) {
				Student student = resultContext.getResultObject();
				map.put(student.getStudId(), student.getName());
				
			}
		};
		
		
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			sqlSession.select(namespace+"selectStudentForMap",resultHandler);
			
			return map;
		}
		
	}
	
	public int updateSetStudent(Student student) {
		log.debug("updateSetStudent()");
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();
		try{	
			
			int res = sqlSession.update(namespace+"updateSetStudent", student);
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
}
