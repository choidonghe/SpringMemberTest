package com.itwillbs.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
	
	@Test
	public void 시간정보조회() {
		System.out.println(" Test : 시간정보조회() 실행");
		logger.info(" Test : 시간정보조회() 실행");
		logger.debug("@@@@@@@@@dubug@@@@@@");		
		
		String time = mdao.gettime();
		System.out.println(" Test : 결과 : " + time);
		logger.info(" Test : 결과 : " + time);
		}
}
