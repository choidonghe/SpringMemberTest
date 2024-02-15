package com.itwillbs.persistence;

import com.itwillbs.domain.MemberVO;

public interface MemberDAO {

	// 디비 시간 
	public String gettime();
	
	// 회원가입
	public void insertMember(MemberVO vo);
	
	// 로그인
	public MemberVO loginMember(MemberVO vo);
	
	// 회원정보 조회
	public MemberVO getMember(String userid);
	
	// 회원정보 수정
	public int updateMember(MemberVO uvo);
	
	//회원정보 삭제
	public int deleteMember(MemberVO dvo);

	
	
}
