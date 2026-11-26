package com.office.vaccin;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class VaccinService {

	final private VaccinDao vaccinDao;
	
	public VaccinService(VaccinDao vaccinDao) {
		this.vaccinDao = vaccinDao;
	}

	public int registeConfirm(HttpServletRequest request, HttpServletResponse response) {
		
		String fvp_name = request.getParameter("fvp_name");
		String ss_number = request.getParameter("ss_number");
		String fvp_mail = request.getParameter("fvp_mail");
		String fvp_phone = request.getParameter("fvp_phone");
		int fv_location_no = Integer.parseInt(request.getParameter("fv_location_no"));
		String fv_type = request.getParameter("fv_type");
		
		VaccinDto vaccinDto = new VaccinDto(fvp_name,ss_number,fvp_mail,
				fvp_phone,fv_location_no,fv_type) ;
		
		int result = vaccinDao.insertNewRegiste(vaccinDto);
		
		if (result > 0) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		
		request.setAttribute("resultForRegiste", result);
				
		return result;
	}

	public void listup(HttpServletRequest request, HttpServletResponse response) {


		List<VaccinDto> vaccinDtos = vaccinDao.selectRegistedPerson();
		
		request.setAttribute("vaccinDtos", vaccinDtos);
		
	}
	
}
