package com.itwillbs.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class MemberDAOTest {
	
	@Inject
	private MemberDAO mdao;
	
	private static final Logger logger 
	= LoggerFactory.getLogger(MemberDAOTest.class);
	
	//@Test
	public void 시간정보조회() {
		System.out.println(" Test : 시간정보조회() 실행");
		logger.info(" Test : 시간정보조회() 실행");
		logger.debug("@@@@@@@@@dubug@@@@@@");		
		
		String time = mdao.gettime();
		System.out.println(" Test : 결과 : " + time);
		logger.info(" Test : 결과 : " + time);
		}
	
	//@Test
	public void 회원가입테스트() {
		logger.debug("회원가입테스트() 실행");			
		logger.debug(" DAO 회원가입 메서드 호출");
			
		MemberVO vo = new MemberVO();
		
		vo.setUserid("admin");
		vo.setUserpw("1234");
		vo.setUsername("관리자");
		vo.setUseremail("admin@admin.com");
		
		mdao.insertMember(vo);
		
		logger.debug("회원가입 완료 @@@@@@@@");
		}
	//@Test
	public void 로그인테스트() {
		logger.debug("로그인테스트() 실행");
		
		//임시 사용자 계정
		MemberVO vo = new MemberVO();
		vo.setUserid("admin"); // 가정) Member - ID
		vo.setUserpw("1234"); // 가정) Board - BNO
		
		//MemberVO resultvo = mdao.loginMember(vo);
		MemberVO resultvo = mdao.loginMember(vo);
		
		if(resultvo != null) {
			logger.debug(" 로그인 성공! ");
			logger.debug(" 메인페이지로 이동 ");
		}else {
			logger.debug(" 로그인 실패! ");
		}
	}
	
	//@Test
	public void 회원정보조회() {
		logger.debug(" 특정 사용자의 정보를 조회하는 메서드 실행! ");
		logger.debug(" id: admin, pw : 1234 계정정보 사용");
		
		MemberVO vo = mdao.getMember("admin");
		
		logger.debug("vo : "+vo);
	}
	
	@Test
	public void 회원정보수정() {
		logger.debug(" 회원정보 수정() 호출");
		
		MemberVO uvo = new MemberVO();
		uvo.setUserid("admin");
		uvo.setUserpw("1234");
		uvo.setUsername("수정관리자");
		
		mdao.updateMember(uvo);
		
	}
	
}
