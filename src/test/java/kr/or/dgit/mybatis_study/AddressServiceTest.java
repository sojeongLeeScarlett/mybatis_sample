package kr.or.dgit.mybatis_study;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.mybatis_study.dto.Address;
import kr.or.dgit.mybatis_study.service.AddressService;

public class AddressServiceTest {
	private static AddressService service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = new AddressService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}

	
	@Test
	public void testAselectAddressByAllWithAPI() {
		RowBounds rowBounds = new RowBounds(0,2);
		List<Address> lists = service.selectAddressByAllWithAPI(rowBounds);
		Assert.assertNotNull(lists);
	}

}
