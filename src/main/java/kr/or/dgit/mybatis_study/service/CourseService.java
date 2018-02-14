package kr.or.dgit.mybatis_study.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_study.dto.Course;
import kr.or.dgit.mybatis_study.util.MyBatisSqlSessionFactory;

public class CourseService {
	private static final CourseService instance = new CourseService();
	private static final Log log = LogFactory.getLog(StudentService.class);
	private String namespace ="kr.or.dgit.mybatis_study.dao.CourseDao.";


	public CourseService() {}

	public static CourseService getInstance() {
		return instance;
	}
	
	public List<Course> selectCourseByCondition(Map<String, Object> map){
		log.debug("selectCourseByCondition()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			
			return sqlSession.selectList(namespace+"selectCourseByCondition", map);
		}
	}
	
	public List<Course> selectCaseCourses(Map<String, Object> map){
		log.debug("selectCaseCourses()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			
			return sqlSession.selectList(namespace+"selectCaseCourses", map);
		}
	}
	
	public List<Course> selectWhereCourses(Map<String, Object> map){
		log.debug("selectWhereCourses()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			
			return sqlSession.selectList(namespace+"selectWhereCourses", map);
		}
	}
	
	public List<Course> selectTrimCourses(Map<String, Object> map){
		log.debug("selectTrimCourses()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			
			return sqlSession.selectList(namespace+"selectTrimCourses", map);
		}
	}
	
	public List<Course> selectCoursesForeachByTutors(Map<String, Object> map){
		log.debug("selectCoursesForeachByTutors()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			
			return sqlSession.selectList(namespace+"selectCoursesForeachByTutors", map);
		}
	}
}
