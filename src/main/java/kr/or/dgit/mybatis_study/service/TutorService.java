package kr.or.dgit.mybatis_study.service;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_study.dao.StudentDao;
import kr.or.dgit.mybatis_study.dao.TutorDao;
import kr.or.dgit.mybatis_study.dto.Tutor;
import kr.or.dgit.mybatis_study.util.MyBatisSqlSessionFactory;

public class TutorService {
	private static final TutorService instance = new TutorService();
	private static final Log log = LogFactory.getLog(TutorService.class);
	

	public static TutorService getInstance() {
		return instance;
	}

	public TutorService() {}
	
	public Tutor selectTutorByTutorId(Tutor tutor) {
		log.debug("selectTutorByTutorId");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			TutorDao tutorDao = sqlSession.getMapper(TutorDao.class);
			return tutorDao. selectTutorByTutorId(tutor);
		}
	}
	
}
