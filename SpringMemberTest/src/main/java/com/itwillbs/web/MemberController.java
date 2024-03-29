package com.itwillbs.web;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.service.MemberService;

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {

	@Inject
	private MemberService mService;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	
	// http://localhost:8088/member/memberjoin
	
	// 회원가입
	@RequestMapping(value = "/memberjoin",method = RequestMethod.GET)
	public void memberJoinGET() {
		
		logger.debug("memberJoinGET() 실행");
		
	}
	
	@RequestMapping(value = "/memberjoin", method = RequestMethod.POST)
	public String memberJoinPOST(MemberVO vo) {
		logger.debug(" memberJoinPOST() 실행");
		
		mService.memberJoin(vo);
		
		return "redirect:/member/login";
		
	}
	@GetMapping(value = "/login")
	public void memberLoginGET() {
		logger.debug("memberLoginGET() 실행");
		
	}
	@PostMapping(value = "/login")
	public String MemberLoginPOST(MemberVO vo, HttpSession session) {
		
		MemberVO resultVO = mService.memberLogin(vo);
		
		String addr ="";
		if(resultVO == null) {
			logger.debug(" 로그인 실패! -> 다시 로그인 ");
			addr ="/member/login";
		}else {
			logger.debug(" 로그인 성공!! -> 메인페이지 ");
			addr ="/member/main";
			session.setAttribute("id", resultVO.getUserid());
			
		}
		
		return "redirect:" + addr;
	}
	@GetMapping(value = "/main")
	public String memberMainGET() {
		logger.debug("memberMainGET()실행");
		
		return "/member/main";
	}
	
	@GetMapping(value = "/logout")
	public String memberLogout(HttpSession session) {
		logger.debug(" memberLogout() 실행");
		
		session.invalidate();
		
		return "redirect:/member/login";
		
	}
	@GetMapping(value = "/info")
	public void memberInfoGET(HttpSession session,Model model) {
		logger.debug("memberInfoGET() 실행");
		
		String id = (String)session.getAttribute("id");
		
		MemberVO resultVO = mService.memberInfo(id);
		
		model.addAttribute("resultVO", resultVO);
	}
	
	@GetMapping(value = "/update")
	public void memberUpdateGET(HttpSession session, Model model) {
		logger.debug("memberUpdateGET() 실행");
		
		String id = (String) session.getAttribute("id");
		
		MemberVO resultVO = mService.memberInfo(id);
		
		model.addAttribute("resultVO", resultVO);
	}
	@PostMapping(value = "/update")
	public String memberUpdatePOST(MemberVO vo) {
		logger.debug("memberUpdatePOST() 실행");
		
		int result = mService.memberUpdate(vo);
		
		if(result == 1) {
			logger.debug(" 수정 성공!! -> 메인페이지 ");
			return "redirect:/member/main";
		}
		
		return "redirect:/member/update";
	}
	@GetMapping(value = "/delete")
	public String memberDeleteGET() {
		logger.debug("memberDeleteGET() 실행");
		
		return "/member/delete";
	}
	
	@PostMapping(value = "delete")
	public String memberDeletePOST(MemberVO vo,HttpSession session) {
		logger.debug("memberDeletePOST() 실행");
	
		int result = mService.memberDelete(vo);
		
		if(result == 1) {
			session.invalidate();
		
			logger.debug(" 삭제 성공!! -> 메인페이지 ");
			return "redirect:/member/main";
	}
		return "redirect:/member/delete";
	}
	@GetMapping(value = "/list")
	public String memberListGET(HttpSession session, MemberVO vo, Model model) {
		logger.debug("memberListGET() 실행");
		
		String id = (String)session.getAttribute("id");
		
		if( id == null || !id.equals("admin")) {
			return "redirect:/member/login";
		}
		
		List<MemberVO> memberList = mService.memberList();
		
		model.addAttribute("memberList", memberList);
		
		return "/member/list";
	}
	
}
