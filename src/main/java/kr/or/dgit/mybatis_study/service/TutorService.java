package kr.or.dgit.mybatis_study.service;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_study.dto.Tutor;
import kr.or.dgit.mybatis_study.util.MyBatisSqlSessionFactory;

public class TutorService {
	private static final Log log = LogFactory.getLog(StudentService.class);
	private String namespace ="kr.or.dgit.mybatis_study.dao.TutorDao.";
	
	public Tutor selectTutorByTutorIdWithAPI(Tutor tutor) {
		log.debug("selectTutorByTutorIdWithAPI()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			
			return sqlSession.selectOne(namespace+"selectTutorByTutorIdWithAPI", tutor);
		}
	}
	
}
