package kr.or.dgit.mybatis_study;

import java.util.Calendar;
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
	public void test3FindStudentWidthAPI() {
		Student student = new Student();
		student.setStudId(1);
		
		Student selectStudent = service.findStudentByNoWithAPI(student);
		Assert.assertNotNull(selectStudent);
		Assert.assertEquals(student.getStudId(), selectStudent.getStudId());
	}
	
	@Test
	public void test4FindStudentByAllWidthAPI() {
		List<Student> listStd = service.findStudentByAllWithAPI();
		
		Assert.assertNotNull(listStd);
		for(Student std:listStd) {
			System.out.println(std);
		}
	}
	

	
	@Test
	public void test5insertStudentWithAPI() {
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1990, 2,28);
		Student student = new Student(3, "홍길동4", "lee@test.co.kr", new PhoneNumber("010-1234-1234"), newDate.getTime());
		int res = service.insertStudentWithAPI(student);
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void test6updateStudentWithAPI() {
		Student student = new Student();
		student.setStudId(1);
		student.setName("Timothy");
		student.setEmail("timothy@gmail.com");
		student.setPhone(new PhoneNumber("123-123-1234"));
		student.setDob(new GregorianCalendar(1988,04,25).getTime());
		int result = service.updateStudentWithAPI(student);
		Assert.assertSame(1, result);
	}
	
	@Test
	public void test6selectStudentByAllForResultMapWithAPI() {
		
		List<Student> listStds = service.findStudentByAllWithAPI();
		List<Student> listStds2 = service.selectStudentByAllForResultMapWithAPI();
		Assert.assertSame(listStds.size(),listStds2.size());
	}
	
	@Test
	public void test7deleteStudentWithAPI() {
		 int deleteStudent = service.deleteStudentWithAPI(3);
		 Assert.assertSame(1, deleteStudent);
	}
	
	

}
