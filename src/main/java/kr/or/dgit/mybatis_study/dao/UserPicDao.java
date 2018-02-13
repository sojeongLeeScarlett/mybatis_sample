package kr.or.dgit.mybatis_study.dao;

import kr.or.dgit.mybatis_study.dto.UserPic;

public interface UserPicDao {
	int insertUserPicWithAPI(UserPic userpic);
	UserPic getUserPicWithAPI(UserPic userpic);
}
