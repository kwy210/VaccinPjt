package com.office.member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberService {
    
	final private MemberDao memberDao;
	
	public MemberService(MemberDao memberDao) {
		this.memberDao = memberDao;
		
	}

	public int signupConfirm(HttpServletRequest request, HttpServletResponse response) {
		
		// id 중복체크
		String admin_id = request.getParameter("admin_id");
		String admin_pw = request.getParameter("admin_pw");
		String admin_mail = request.getParameter("admin_mail");
		String admin_phone = request.getParameter("admin_phone");
	

		boolean isMember = memberDao.isMember(admin_id);
	
		if (!isMember) {
			int result = memberDao.insertNewMember(
					new MemberDto(admin_id, admin_pw, admin_mail, admin_phone));
	
	if (result > 0) {
		System.out.println("[MemberService] Sign_up SUCCESS");
	} else {
		System.out.println("[MemberService] Sigm_ng FAIL");
	}
	
	
	}
		
		
		
		// 회원가입
		
		return 0;
	}

	public String signinform(HttpServletRequest request, HttpServletResponse response) {
	
		String memId = request.getParameter("memId");
		String memPw = request.getParameter("memPw");
		
		MemberDto selectedMemberDto = memberDao.selectMemberByMemId(memId);
		
		if (selectedMemberDto != null &&selectedMemberDto.getAdmin_pw().equals(admin_pw)) {
			System.out.println("[MemberService] Sign_up SUCCESS");
			
			return admin_id;
			
		} else {
			System.out.println("[MemberService] Sigm_ng FAIL");
		
			return null;
		
	}
	
}
