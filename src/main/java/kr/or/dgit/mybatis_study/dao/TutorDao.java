package kr.or.dgit.mybatis_study.dao;

import kr.or.dgit.mybatis_study.dto.Tutor;

public interface TutorDao {
	Tutor selectTutorByTutorIdWithAPI(Tutor tutor);
}
