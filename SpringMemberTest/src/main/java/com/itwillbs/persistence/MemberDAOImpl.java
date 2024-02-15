package com.itwillbs.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO{

	@Inject
	public SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);
	private static final String NAMESPACE = ("com.itwillbs.mapper.MemberMapper");
	
	@Override
	public String gettime() {
		System.out.println(" DAOImpl : + getTime() 실행 ");
		logger.debug("DAO log debug@@@@@@");
		
		String time
		= sqlSession.selectOne("com.itwillbs.mapper.MemberMapper.getTime");
		
		System.out.println(" DAOImpl : " +time);
		
		return time;
	}

}
