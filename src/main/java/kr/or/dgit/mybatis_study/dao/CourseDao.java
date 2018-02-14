package kr.or.dgit.mybatis_study.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.mybatis_study.dto.Course;

public interface CourseDao {
	
	//if
	List<Course> selectCourseByCondition(Map<String, Object> map);
	
	//choose,when,otherwise(else)
	List<Course> selectCaseCourses(Map<String, Object> map);
	
	//where
	List<Course> selectWhereCourses(Map<String, Object> map);
	
	//trim
	List<Course> selectTrimCourses(Map<String, Object> map);
	
	//foreach
	List<Course> selectCoursesForeachByTutors(Map<String, Object> map);
	
	
}
