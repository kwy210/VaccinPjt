package com.office.vaccin;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import com.office.DatabaseInfo;

public class VaccinDao implements DatabaseInfo{
	

	public int insertNewRegiste(VaccinDto vaccinDto) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = -1;
		
		try {
			//1. 드라이버 로드 메모리	
			Class.forName(DRIVER);
			
			//2. 다리 연결 : 커넷션
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			//3. 작업 지시서 작성: SQL문
			String sql = "insert into "
					+ "tbl_flu_vaccin_person("
					+ "fvp_name,"
					+ "ss_number,"
					+ "fvp_mail,"
					+ "fvp_phone,"
					+ "fv_location_no,"
					+ "fv_type)"
					+ "values(?, ?, ?, ?, ?, ?)";
			
			//4. 일꾼 구한다.
			pstmt = conn.prepareStatement(sql);
			
			//5. 데이터 주입 일꾼에게
			pstmt.setString(1, vaccinDto.getFvp_name());
			pstmt.setString(2, vaccinDto.getSs_number());
			pstmt.setString(3, vaccinDto.getFvp_mail());
			pstmt.setString(4, vaccinDto.getFvp_phone());
			pstmt.setInt(5, vaccinDto.getFv_location_no());
			pstmt.setString(6, vaccinDto.getFv_type());
			
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	return	result ;
		
	}

	public List<VaccinDto> selectRegistedPerson() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet  rs;
		
		try {
			//1. 드라이버 로드 메모리	
			Class.forName(DRIVER);
			
			//2. 다리 연결 : 커넷션
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			//3. 작업 지시서 작성: SQL문
			String sql = "select * from tbl_flu_vaccin_person fvp "
					+ "join tbl_social_number sn "
					+ "on fvp.ss_number = sn.ss_number "
					+ "join tbl_fv_location fl "
					+ "on fl.fv_location_no = fl.fv_location_no "
					+ "join tbl_fv_type ft "
					+ "on fvp.fv_type = ft.fv_type "
					+ "order by fvp.fvp_no desc ";
			
			//4. 일꾼 구한다.
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
		while (rs.next()) {
			int fvp_no = rs.getInt("fvp_no");
			String fvp_name = rs.getInt("fvp_name");
			String ss_number = rs.getInt("ss_number");
			String fvp_mail = rs.getInt("fvp_mail");
			String fvp_phone = rs.getInt("fvp_phone");
			int fv_location_no = rs.getInt("fv_location_no");
			String fv_type = rs.getInt("fv_type");
			String fvp_date = rs.getInt("fvp_date");
			
			// SocialNumberDto
			
			rs.getString("ss_number");
			rs.getString("rs_name");
			rs.getString("rs_addr");
			rs.getString("rs_phone");
			rs.getString("rs_date");
			
		}
			
		} catch (Exception e) {
		    System.out.println("DB INSERT 실패");
		    e.printStackTrace();
			
		}finally {
			try {
				if (rs.set)
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		result = pstmt.executeUpdate();

		System.out.println("INSERT 실행 결과: " + result);
		
	return	result ;
		
	}
			
  }

	


	