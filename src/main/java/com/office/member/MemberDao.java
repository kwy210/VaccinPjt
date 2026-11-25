package com.office.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.office.DatabaseInfo;

public class MemberDao implements DatabaseInfo{
	

	
	
	public memberDao isMember(String admin_id)  {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = -1;
		
		try {
			//1. 드라이버 로드 메모리	
			Class.forName(DRIVER);
			
			//2. 다리 연결 : 커넷션
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			//3. 작업 지시서 작성: SQL문
			String sql = "select count(*) cnt tbl_admin where admin_id = ? ";
			
			//4. 일꾼 구한다.
			pstmt = conn.prepareStatement(sql);
			
			//5. 데이터 주입 일꾼에게
			pstmt.setString(1, admin_id);
			
			//6 작업지시
			pstmt.executeQuery();
			
			//7. 데이터 추출
			while (rs.next()) {
				result = rs.getInt("cnt");
				
			}
			
					
		}catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			//8. 외부자원 해제
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		return result > 0 ? true:false;
	}

	public void insertNewMember(MemberDto memberDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			//1. 드라이버 로드 메모리	
			Class.forName(DRIVER);
			
			//2. 다리 연결 : 커넷션
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			//3. 작업 지시서 작성: SQL문
			String sql = "insert into "
					+ "tbl_admin(admin_id,admin_pw,admin_mail,admin_phone) "
					+ "valuse(?, ?, ?, ?) ";
			
			//4. 일꾼 구한다.
			pstmt = conn.prepareStatement(sql);
			
			//5. 데이터 주입 일꾼에게
			pstmt.setString(1, memberDto.getAdmin_id());
			pstmt.setString(2, memberDto.getAdmin_pw());
			pstmt.setString(3, memberDto.getAdmin_mail());
			pstmt.setString(4, memberDto.getAdmin_phone());
			
			//6 작업지시
			pstmt.executeQuery();
			
			
		}catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			//8. 외부자원 해제
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		return result;
		
	}

}
