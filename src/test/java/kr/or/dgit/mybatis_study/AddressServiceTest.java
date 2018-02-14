package kr.or.dgit.mybatis_study;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.mybatis_study.dto.Address;
import kr.or.dgit.mybatis_study.service.AddressService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
	public void test1selectAddressByAll() {
		RowBounds rowBounds = new RowBounds(0,2);
		List<Address> lists = service.selectAddressByAll(rowBounds);
		Assert.assertNotNull(lists);
		
	}
	
	@Test
	public void test2selectAddressLimitByAll() {
		Map<String, Integer> map = new HashMap<>();
		map.put("offset", 2);
		map.put("limit", 2);
	
		List<Address> lists = service.selectAddressLimitByAll(map);
		Assert.assertNotNull(lists);
		
	}

}
