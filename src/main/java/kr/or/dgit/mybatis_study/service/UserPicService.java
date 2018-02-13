package kr.or.dgit.mybatis_study.service;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_study.dao.UserPicDao;
import kr.or.dgit.mybatis_study.dto.UserPic;
import kr.or.dgit.mybatis_study.util.MyBatisSqlSessionFactory;

public class UserPicService {
	private static final Log log = LogFactory.getLog(UserPicService.class);
	

	public UserPicService() {}


	public int insertUserPic(UserPic userpic) {
		log.debug("insertUserPic()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			
			UserPicDao upDao = sqlSession.getMapper(UserPicDao.class);
			int res = upDao.insertUserPic(userpic);
			sqlSession.commit();
			return res;	
		}	
		
	}
	
	public UserPic getUserPic(UserPic userpic) {
		log.debug("getUserPic()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			
			UserPicDao userPicDao = sqlSession.getMapper(UserPicDao.class);
			return userPicDao.getUserPic(userpic);
					
		}

	}
	
	
}
