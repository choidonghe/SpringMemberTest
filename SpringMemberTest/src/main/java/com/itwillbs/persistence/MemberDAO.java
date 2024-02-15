package com.itwillbs.persistence;

import com.itwillbs.domain.MemberVO;

public interface MemberDAO {

	// 디비 시간 
	public String gettime();
	
	// 회원가입
	public void insertMember(MemberVO vo);
	
	// 로그인
	public MemberVO loginMember(MemberVO vo);
	
	// 회원정보
	public MemberVO getMember(String userid);
	
}
