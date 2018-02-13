package kr.or.dgit.mybatis_study;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


import kr.or.dgit.mybatis_study.dto.Tutor;
import kr.or.dgit.mybatis_study.service.TutorService;

public class TutorSerivceTest {
	public static TutorService service;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = new TutorService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1selectTutorByTutorIdWithAPI() {
		Tutor findTutor = new Tutor();
		findTutor.setTutorId(1);
		Tutor tutor = service.selectTutorByTutorIdWithAPI(findTutor);
		Assert.assertEquals(tutor.getTutorId(), findTutor.getTutorId());
	}

}
