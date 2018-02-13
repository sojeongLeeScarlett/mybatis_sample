package kr.or.dgit.mybatis_study;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.mybatis_study.dto.UserPic;
import kr.or.dgit.mybatis_study.service.UserPicService;

public class UserPicServiceTest {
	private static UserPicService service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = new UserPicService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}



	@Test
	public void test1insertUserPic() {
		UserPic userpic = new UserPic();
		userpic.setName("jjj");
		userpic.setBio("put some lengthy bio here");
		userpic.setPic(getpicFile());
		System.out.println(userpic);
		
		int result = service.insertUserPicWithAPI(userpic);
		Assert.assertSame(1, result);
	}

	private byte[] getpicFile() {
		byte[] pic = null;
		File file = new File(System.getProperty("user.dir")+"\\DataFiles\\show.jpg");
		try {
			InputStream is = new FileInputStream(file);
			pic = new byte[is.available()];
			is.read(pic);
			is.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(pic);
		return pic;
	}
	
	@Test
	public void test2getUserPic() {
		UserPic finduserpic = new UserPic();
		finduserpic.setId(1);
		UserPic userpic = service.getUserPicWithAPI(finduserpic);
		Assert.assertNotNull(userpic);
	}
	


}
