package kr.or.dgit.mybatis_study;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.mybatis_study.dto.Student;
import kr.or.dgit.mybatis_study.service.StudentService;

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
	public void testFindStudent() {
		Student student = new Student();
		student.setStudId(1);
		
		Student selectStudent = service.findStudentByNo(student);
		Assert.assertEquals(student.getStudId(), selectStudent.getStudId());
	}

}
