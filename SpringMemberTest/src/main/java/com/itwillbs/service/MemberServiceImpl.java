package com.itwillbs.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Inject
	private MemberDAO mdao;
	
	@Override
	public String gettime() {
		
		logger.debug("gettime() 실행 ");
		
		return mdao.gettime();
	}

	@Override
	public void memberJoin(MemberVO vo) {
		logger.debug(" memberJoin(MemberVO vo) 실행");
		
		mdao.insertMember(vo);
		
		logger.debug("회원가입완료");
		
		
	}

	@Override
	public MemberVO memberLogin(MemberVO vo) {
		logger.debug("memberLogin(MemberVO vo) 실행");

		return mdao.loginMember(vo);
	}

	@Override
	public MemberVO memberInfo(String id) {
		logger.debug("memberInfo(String id) 실행");
		
		MemberVO resultVO = mdao.getMember(id);
		
		return resultVO;
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		logger.debug("memberUpdate(MemberVO vo) 실행");
		
		
		return mdao.updateMember(vo);
	}

	@Override
	public int memberDelete(MemberVO vo) {
		logger.debug("memberDelete(MemberVO vo) 실행");
		
		return mdao.deleteMember(vo);
	}
	
	
	
	
	
	
	
	
	
	
	

}
