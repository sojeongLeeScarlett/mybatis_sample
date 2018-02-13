package kr.or.dgit.mybatis_study;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.mybatis_study.dto.Tutor;
import kr.or.dgit.mybatis_study.service.TutorService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TutorServiceTest {
	private static TutorService service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = TutorService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}

	

	@Test
	public void test1selectTutorByTutorId() {
		
		Tutor findTutor = new Tutor();
		findTutor.setTutorId(1);
		Tutor tutor = service.selectTutorByTutorId(findTutor);
		Assert.assertEquals(tutor.getTutorId(),findTutor.getTutorId());
		
	}

}
