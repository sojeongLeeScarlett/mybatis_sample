package kr.or.dgit.mybatis_study.service;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_study.dto.UserPic;
import kr.or.dgit.mybatis_study.util.MyBatisSqlSessionFactory;

public class UserPicService {
	private static final Log log = LogFactory.getLog(UserPicService.class);
	private String namespace ="kr.or.dgit.mybatis_study.dao.UserPicDao.";
	
	public UserPicService() {}
	
	public int insertUserPicWithAPI(UserPic userpic) {
		log.debug("insertUserPicWithAPI()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			int res =  sqlSession.insert(namespace+"insertUserPicWithAPI",userpic);
			sqlSession.commit();
			return res;
		}	
		
	}
	
	public UserPic getUserPicWithAPI(UserPic userpic) {
		log.debug("getUserPicWithAPI()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			return sqlSession.selectOne(namespace + "getUserPicWithAPI", userpic);
		}

	}
	
}
