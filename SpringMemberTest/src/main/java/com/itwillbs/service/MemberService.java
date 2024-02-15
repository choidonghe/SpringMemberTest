package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.MemberVO;

public interface MemberService {
	
	// 시간정보
	public String gettime();
	
	// 회원가입
	public void memberJoin(MemberVO vo);
	
	// 로그인
	public MemberVO memberLogin(MemberVO vo);
	
	// 회원정보
	public MemberVO memberInfo(String id);
	
	// 회원정보 수정
	public int memberUpdate(MemberVO vo);
	
	// 회원정보 삭제
	public int memberDelete(MemberVO vo);
	
	// 회원목록
	public List<MemberVO> memberList();
	
}
