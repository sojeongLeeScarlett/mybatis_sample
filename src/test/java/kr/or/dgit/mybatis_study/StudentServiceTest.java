package kr.or.dgit.mybatis_study;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.mybatis_study.dto.PhoneNumber;
import kr.or.dgit.mybatis_study.dto.Student;
import kr.or.dgit.mybatis_study.service.StudentService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentServiceTest {
	private static StudentService service;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = new StudentService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}


	@Test
	public void test1FindStudent() {
		Student student = new Student();
		student.setStudId(1);
		
		Student selectStudent = service.findStudentByNo(student);
		Assert.assertNotNull(selectStudent);
		Assert.assertEquals(student.getStudId(), selectStudent.getStudId());
	}
	
	@Test
	public void test2FindStudentByAll() {
		List<Student> listStd = service.findStudentByAll();
		
		Assert.assertNotNull(listStd);
		for(Student std:listStd) {
			System.out.println(std);
		}
	}
	
	
	
	@Test
	public void test5insertStudent() {
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1990, 2,28);
		Student student = new Student(3, "홍길동3", "lee@test.co.kr", new PhoneNumber("010-1234-1234"), newDate.getTime());
		int res = service.insertStudent(student);
		Assert.assertEquals(1, res);
	}
	

	@Test
	public void test6updateStudent() {
		Student student = new Student();
		student.setStudId(1);
		student.setName("Timothy");
		student.setEmail("test@test.co.kr");
		student.setPhone(new PhoneNumber("987-654-3211"));
		student.setDob(new Date());
		int result = service.updateStudent(student);
		Assert.assertEquals(1, result);
	}
	
	
	@Test
	public void test6selectStudentByAllForResultMap() {
		List<Student> lists = service.selectStudentByAllForResultMap();
		List<Student> listsAPI = service.selectStudentByAllForResultMap();
		Assert.assertEquals(listsAPI, lists);
	}
	
	@Test
	public void test7deleteStudent() {
		int deleteStudent = service.deleteStudent(3);
		Assert.assertSame(1, deleteStudent);
	}
	
	

}
