package kr.or.dgit.mybatis_study;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mysql.fabric.xmlrpc.base.Data;

import kr.or.dgit.mybatis_study.dto.Course;
import kr.or.dgit.mybatis_study.service.CourseService;

public class CourseServiceTest {
	private static CourseService service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = CourseService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}

	@Test
	public void test1selectCourseByCondition() {
		GregorianCalendar cal = new GregorianCalendar(2013,1,1);
		Map<String, Object> map = new HashMap<>();
		map.put("tutorId", 1);
		map.put("name", "%Java%");
		map.put("startDate", cal.getTime());
		
		List<Course> courses = service.selectCourseByCondition(map);
		Assert.assertNotNull(courses);
	}
	
	@Test
	public void test2selectCaseCourses() {
		Map<String, Object> map = new HashMap<>();
		
		map.put("searchBy", "tutorId");
		map.put("tutorId", 1);
		
		
		List<Course> courses = service.selectCaseCourses(map);
		Assert.assertNotNull(courses);
		
		map.replace("searchBy", "name");
		map.remove("tutorId");
		map.put("name", "%Java%");
		courses = service.selectCaseCourses(map);
		Assert.assertNotNull(courses);
	}
	
	@Test
	public void test3selectWhereCourses() {
		
		Map<String, Object> map = new HashMap<>();
		List<Course> courses = service.selectCourseByCondition(map);
		Assert.assertNotNull(courses);
		map.put("tutorId", 1);
		map.put("name", "%Java%");
		map.clear();
		map.put("tutorId", 1);
		map.put("name", "%Java%");
		map.put("endDate", new Date());
		courses = service.selectWhereCourses(map);
	}
	
	@Test
	public void test4selectTrimCourses() {
		
		Map<String, Object> map = new HashMap<>();
		List<Course> courses = service.selectTrimCourses(map);
		Assert.assertNotNull(courses);
		
		map.put("tutorId", 1);
		courses = service.selectTrimCourses(map);
		Assert.assertNotNull(courses);
		
		map.put("tutorId", 1);
		map.put("name", "%Java%");
		courses = service.selectTrimCourses(map);
		Assert.assertNotNull(courses);
	}
	
	@Test
	public void selectCoursesForeachByTutors() {
		List<Integer> tutorId = new ArrayList<Integer>();
		tutorId.add(1);
		tutorId.add(2);
		
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("tutorId", tutorId);
		
		List<Course> courses = service.selectCoursesForeachByTutors(map);
		Assert.assertNotNull(courses);
	}
	

}
