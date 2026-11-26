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
		List<VaccinDto> vaccinDtos = ArrayList<VaccinDto>();
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
				
				// VaccinDto
				int fvp_no = rs.getInt("fvp_no");
				String fvp_name = rs.getString("fvp_name");
				String ss_number = rs.getString("ss_number");
				String fvp_mail = rs.getString("fvp_mail");
				String fvp_phone = rs.getString("fvp_phone");
				int fv_location_no = rs.getInt("fv_location_no");
				String fv_type = rs.getString("fv_type");
				String fvp_reg_date = rs.getString("fvp_reg_date");
				
				// SocialNumberDto
				rs.getString("ss_number");
				rs.getString("ss_name");
				rs.getString("ss_addr");
				rs.getString("ss_phone");
				rs.getString("ss_date");
				
				
				// LocationDto
				int fv_location_no = rs.getString("fv_location_name");
				
				// TypeDto
				
				// assemble
				
				VaccinDto vaccinDto = new VaccinDto(fvp_no, fvp_name, null, fvp_mail, fvp_phone, fv_location_no, fv_type, fvp_reg_date)
				
				SocialNumberDto socialNumberDto = new SocialNumberDto(s, fv_type, fvp_phone, fvp_reg_date)		
						
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
		
		return vaccinDtos;
		
	}

}


	