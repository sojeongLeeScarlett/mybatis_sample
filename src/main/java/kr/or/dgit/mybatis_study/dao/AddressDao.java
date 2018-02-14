package kr.or.dgit.mybatis_study.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import kr.or.dgit.mybatis_study.dto.Address;

public interface AddressDao {
	List<Address> selectAddressByAllWithAPI(RowBounds rowbounds);
	List<Address> selectAddressLimitByAllWithAPI(Map<String, Integer> map);
}
