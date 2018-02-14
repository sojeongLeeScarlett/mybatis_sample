package kr.or.dgit.mybatis_study.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_study.dao.AddressDao;
import kr.or.dgit.mybatis_study.dto.Address;
import kr.or.dgit.mybatis_study.util.MyBatisSqlSessionFactory;

public class AddressService {
	private static final Log log = LogFactory.getLog(AddressService.class);
	
	public List<Address> selectAddressByAll(RowBounds rowbounds){
		log.debug("selectAddressByAll()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			AddressDao addressDao = sqlSession.getMapper(AddressDao.class);
			return addressDao.selectAddressByAll(rowbounds);
		}
	}
	
	public List<Address> selectAddressLimitByAll(Map<String, Integer> map){
		log.debug("selectAddressLimitByAll()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			AddressDao addressDao = sqlSession.getMapper(AddressDao.class);
			return addressDao.selectAddressLimitByAll(map);
		}
	}
}
