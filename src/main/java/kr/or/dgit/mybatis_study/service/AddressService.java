package kr.or.dgit.mybatis_study.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_study.dao.AddressDao;
import kr.or.dgit.mybatis_study.dto.Address;
import kr.or.dgit.mybatis_study.util.MyBatisSqlSessionFactory;

public class AddressService {
	public List<Address> selectAddressByAll(RowBounds rowbounds){
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			AddressDao addressDao = sqlSession.getMapper(AddressDao.class);
			return addressDao.selectAddressByAll(rowbounds);
		}
	}
}
