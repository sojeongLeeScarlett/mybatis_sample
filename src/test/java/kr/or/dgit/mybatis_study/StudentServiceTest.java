package kr.or.dgit.mybatis_study;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.mybatis_study.dto.PhoneNumber;
import kr.or.dgit.mybatis_study.dto.Student;
import kr.or.dgit.mybatis_study.service.StudentService;
import kr.or.dgit.mybatis_study.type.Gender;

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
	public void test8selectStudentByAllForResultMap() {
		List<Student> lists = service.findStudentByAll();
		List<Student> lists2 = service.selectStudentByAllForResultMap();
		Assert.assertSame(lists.size(),lists2.size());
	}
	@Test
	public void test9selectStudentByAllForHashMap() {
		List<Map<String, Object>> listMaps = service.selectStudentByAllForHashMap();
		List<Student> lists2 = service.findStudentByAll();
		Assert.assertSame(listMaps.size(), lists2.size());
		for(Map<String, Object> map:listMaps) {
			for(java.util.Map.Entry<String, Object> e :map.entrySet()) {
				System.out.printf("key %s => vlaue %s %n",e.getKey(),e.getValue());
			}
		}
	}
	
	@Test
	public void test10selectStudentByNoForResultMapExtends() {
		Student student = new Student();
		student.setStudId(1);
		Student extStd = service.findStudentByNo(student);
		Student extStd2 = service.selectStudentByNoForResultMapExtends(student);
		Assert.assertEquals(extStd.getStudId(),extStd2.getStudId());
	}
	
	@Test
	public void test11selectStudentByNoAssociation() {
		Student student = new Student();
		student.setStudId(1);
		Student extStd = service.findStudentByNo(student);
		Student extStd2 = service.selectStudentByNoAssociation(student);
		Assert.assertEquals(extStd.getStudId(),extStd2.getStudId());
		
	}
	
	@Test
	public void test12selectAllStudentByParam() {
		Student student = service.selectAllStudentByParam("Timothy", "test@test.co.kr");
		Assert.assertNotNull(student);	
	}
	
	
	@Test
	public void test13selectAllStudentByStudent() {
		Student std = new Student();
		std.setName("Timothy");
		std.setEmail("test@test.co.kr");
		Student student = service.selectAllStudentByStudent(std);
		Assert.assertNotNull(student);
	}
	
	@Test
	public void test14selectAllStudentByMap() {
		Map<String, String> maps = new HashMap<>();
		maps.put("name", "Timothy");
		maps.put("email", "test@test.co.kr");
		Student student = service.selectAllStudentByMap(maps);
		Assert.assertNotNull(student);
	}
	
	
	@Test
	public void test7deleteStudent() {
		int deleteStudent = service.deleteStudent(3);
		Assert.assertSame(1, deleteStudent);
	}
	
	@Test
	public void testFinsertEnumStudent() {
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1990, 2,28);
		Student student = new Student(3, "홍길동3", "lee@test.co.kr", new PhoneNumber("010-1234-1234"), newDate.getTime());
		student.setGender(Gender.FEMALE);
		int res = service.insertEnumStudent(student);
		Assert.assertEquals(1, res);
		System.out.println(student);
		
	}
	
	

}
