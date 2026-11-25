package com.office.member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.mem")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MemberController() {
        super();
    }

	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		MemberService memberService = null;
		String nextPage = null;
		
		switch (command) {
		case "/signup_form.mem":		// 회원가입 양식
			
			nextPage = generateView("signup_form");
			
			break;
			
		case "/signup_confirm.mem":		// 회원가입 확인
			
			memberService = new MemberService(new MemberDao()); //제어의 역전 ioc
			int resultForConfirm  = memberService.signupConfirm(request, response);
			
			if (resultForConfirm > 0) {
				nextPage = generateView("sign_ok");
			}else {
				nextPage = generateView("sign_ng");
			}
			
			break;
			
		case "/signin_form.mem":
			
			nextPage = generater
			
			
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

	private String generateView(String viewName) {
		return "view/member/" + viewName + ".jsp";
		
	}
	
}
