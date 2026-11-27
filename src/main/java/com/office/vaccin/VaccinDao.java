package com.office.vaccin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.office.DatabaseInfo;

public class VaccinDao implements DatabaseInfo {

	public int insertNewRegiste(VaccinDto vaccinDto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = -1;
		
		try {
			
			Class.forName(DRIVER);
			
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			String sql =  "insert into "
						+ 	"tbl_flu_vaccin_person("
						+ 		"fvp_name, "
						+ 		"ss_number, "
						+ 		"fvp_mail, "
						+ 		"fvp_phone, "
						+ 		"fv_location_no, "
						+ 		"fv_type) "
						+ "values(?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vaccinDto.getFvp_name());
			pstmt.setString(2, vaccinDto.getSs_number());
			pstmt.setString(3, vaccinDto.getFvp_mail());
			pstmt.setString(4, vaccinDto.getFvp_phone());
			pstmt.setInt(5, vaccinDto.getFv_location_no());
			pstmt.setString(6, vaccinDto.getFv_type());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
				
			}
			
		}
		
		return result;
		
	}

public List<VaccinDto> selectRegistedPerson() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<VaccinDto> vaccinDtos = new ArrayList<VaccinDto>();
		
		try {
			
			Class.forName(DRIVER);
			
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			String sql =  "select * from tbl_flu_vaccin_person fvp "
						+ "join tbl_social_number sn "
						+ "on fvp.ss_number = sn.ss_number "
						+ "join tbl_fv_location fl  "
						+ "on fvp.fv_location_no = fl.fv_location_no  "
						+ "join tbl_fv_type ft  "
						+ "on fvp.fv_type = ft.fv_type  "
						+ "order by fvp.fvp_no desc";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				System.out.println("++++++++++");
				
				// VaccinDto
				int fvp_no = rs.getInt("fvp_no");
				String fvp_name = rs.getString("fvp_name");
				String fvp_mail = rs.getString("fvp_mail");
				String fvp_phone = rs.getString("fvp_phone");
				String fvp_reg_date = rs.getString("fvp_reg_date");
				
				// SocialNumberDto
				String ss_number = rs.getString("ss_number");
				String ss_name = rs.getString("ss_name");
				String ss_addr = rs.getString("ss_addr");
				String ss_phone = rs.getString("ss_phone");
				String ss_reg_date = rs.getString("ss_reg_date");
				
				// LocationDto
				int fv_location_no = rs.getInt("fv_location_no");
				String fv_location_name = rs.getString("fv_location_name");
				String fv_location_addr = rs.getString("fv_location_addr");
				String fv_location_phone = rs.getString("fv_location_phone");
				String fv_location_manager = rs.getString("fv_location_manager");
				
				// TypeDto
				int fv_type_no = rs.getInt("fv_type_no");
				String fv_type = rs.getString("fv_type");
				String fv_type_manuf_country = rs.getString("fv_type_manuf_country");
				String fv_type_manuf_date = rs.getString("fv_type_manuf_date");
				
				// assemble
				VaccinDto vaccinDto = new VaccinDto(fvp_no, fvp_name, null, fvp_mail, fvp_phone, 0, null, fvp_reg_date);
				
				SocialNumberDto socialNumberDto = new SocialNumberDto(ss_number, ss_name, ss_addr, ss_phone, ss_reg_date);
				LocationDto locationDto = new LocationDto(fv_location_no, fv_location_name, fv_location_addr, fv_location_phone, fv_location_manager);
				TypeDto typeDto = new TypeDto(fv_type_no, fv_type, fv_type_manuf_country, fv_type_manuf_date);
				
				vaccinDto.setSocialNumberDto(socialNumberDto);
				vaccinDto.setLocationDto(locationDto);
				vaccinDto.setTypeDto(typeDto);
				
				vaccinDtos.add(vaccinDto);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
				
			}
			
		}
		
		System.out.println("dao" + vaccinDtos.size());
		
		return vaccinDtos;
		
	}

public VaccinDto selselectedVaccinDtoByFvpNo(int no) {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	List<VaccinDto> vaccinDtos = new ArrayList<VaccinDto>();
	
	try {
		
		Class.forName(DRIVER);
		
		conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		
		String sql =  "select * from tbl_flu_vaccin_person where fvp_no =?";
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, no);
		
		rs = pstmt.executeQuery();
		
		while (rs.next()) {
			
			// VaccinDto
			int fvp_no = rs.getInt("fvp_no");
			String fvp_name = rs.getString("fvp_name");
			String ss_number = rs.getString("ss_number");
			String fvp_mail = rs.getString("fvp_mail");
			String fvp_phone = rs.getString("fvp_phone");
			int fv_location_no = rs.getInt("fv_location_no");
			String fv_type = rs.getString("fv_type");
			String fvp_reg_date = rs.getString("fvp_reg_date");
			
			VaccinDto dto = new VaccinDto(fvp_no, fvp_name, ss_number, fvp_mail, fvp_phone, fv_location_no, fv_type, fvp_reg_date);
			
			vaccinDtos.add(dto);
			
		}
		
	} catch (Exception e) {
		e.printStackTrace();
		
	} finally {
		
		try {
			
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
			
		} catch (Exception e2) {
			e2.printStackTrace();
			
		}
		
	}
	
	return vaccinDtos.get(0);
	
}

public int update(VaccinDto vaccinDto) {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	int result = -1;
	
	try {
		
		Class.forName(DRIVER);
		
		conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		
		String sql =  "update "
					+ 	"tbl_flu_vaccin_person"
					+ "set "
					+ 	"fvp_name		= ?, "
					+ 	"ss_number		= ?, "
					+ 	"fvp_mail		= ?, "
					+ 	"fvp_phone		= ?, "
					+ 	"fv_location_no	= ?, "
					+ 	"fv_type 		= ? "
					+ "where "
					+ 	"fvp_no = ?";
					
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, vaccinDto.getFvp_name());
		pstmt.setString(2, vaccinDto.getSs_number());
		pstmt.setString(3, vaccinDto.getFvp_mail());
		pstmt.setString(4, vaccinDto.getFvp_phone());
		pstmt.setInt(5, vaccinDto.getFv_location_no());
		pstmt.setString(6, vaccinDto.getFv_type());
		pstmt.setInt(7, vaccinDto.getFvp_no());
		
		result = pstmt.executeUpdate();
		
	} catch (Exception e) {
		e.printStackTrace();
		
	} finally {
		
		try {
			
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
			
		} catch (Exception e2) {
			e2.printStackTrace();
			
		}
		
	}
	
	return result;
}

}