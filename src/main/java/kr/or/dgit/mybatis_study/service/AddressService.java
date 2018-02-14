package kr.or.dgit.mybatis_study.service;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_study.dto.Address;
import kr.or.dgit.mybatis_study.util.MyBatisSqlSessionFactory;

public class AddressService {
	private static final Log log = LogFactory.getLog(StudentService.class);
	private String namespace ="kr.or.dgit.mybatis_study.dao.AddressDao.";
	
	
	public List<Address> selectAddressByAllWithAPI(RowBounds rowbounds){
		log.debug("selectAddressByAllWithAPI()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			
			return sqlSession.selectList(namespace+"selectAddressByAllWithAPI",null,rowbounds);
		}
	}
}
