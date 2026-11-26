package com.office.vaccin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.eclipse.tags.shaded.org.apache.regexp.recompile;


@WebServlet("*.vac")
public class VaccinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public VaccinController() {
    	 super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String requestURI = request.getRequestURI();
		String contextpath = request.getContextPath();
		String command = requestURI.substring(contextpath.length());
		
		VaccinService vaccinService = null;
		String nextPage = null;
		
		switch (command) {
		case "/injection_registe_form.vac": 
			
			nextPage = generateView("registe_form");
			
			break;
			
		case "/injection_registe_confirm.vac":
			
			vaccinService = new VaccinService(new VaccinDao());
			int resultForRegist = 
					vaccinService.registeConfirm(request, response);
			
			nextPage = generateView("registe_result");
			
			
			break;
			
			
		case "/injection_list.vac":
			
			vaccinService = new VaccinService(new VaccinDao());
			vaccinService.listup(request, response);
			
			nextPage = generateView("registed_list");
			
			break;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

	private String generateView(String viewName) {
	    return "/view/vaccin/" + viewName + ".jsp";
	}
	
}
