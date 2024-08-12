package com.kh.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.model.vo.Prize;

public class PrizeDao {

	private Properties prop = new Properties();
	
	public PrizeDao() {
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 1. 수상자 등록
	public int insertRecipient(Connection conn, Prize p) {
		
		// INSERT 문 --> int (처리된 갯수) --> 트랜잭션 처리
		
		// 0) 필요한 변수들 셋팅
		int result = 0;
		PreparedStatement pstmt = null;
		
		// 실행할 SQL 문 (미완성된 형태, 세미콜론 X)
		String sql = prop.getProperty("insertRecipient");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, p.getRecipientName());
			pstmt.setString(2, p.getPrizeName());
			pstmt.setInt(3, p.getPrizeMoney());
			pstmt.setString(4, p.getRecipientNo());
			pstmt.setString(5, p.getGender());
			pstmt.setString(6, p.getPhone());
			// 이 시점부터 SQL 문이 완성된 형태
			
			//4, 5) SQL 문 실행 후 결과 받기
			//	INSERT 문 : executeUpdate 메소드
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			// JDBCTemplate 용 객체 자원 반납
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	} // insertRecipient 메소드 영역 끝
	
	// 2. 전체 수상자 조회
	public ArrayList<Prize> selectAll(Connection conn) {
		// 0) 필요한 변수들 셋팅
		ArrayList<Prize> list = new ArrayList<>();
		PreparedStatement pstmt = null; // SQL 문 실행 후 결과를 받을 변수
		ResultSet rset = null; // SELECT 문이 실행된 결과를 받을 변수
		
		// 실행할 SQL 문 (세미콜론 X)
		String sql = prop.getProperty("selectAll");
		
		// PreparedStatement 객체 생성
		try {
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// SQL 문 실행 후 결과 받기
			rset = pstmt.executeQuery();
			
			// ResultSet 에서 한 행씩 뽑아서 VO로 옮기기
			while(rset.next()) {
			
				list.add(new Prize(rset.getInt("PRIZE_NO"),
						   rset.getString("RECIPIENT_NAME"),
						   rset.getString("PRIZE_NAME"),
						   rset.getInt("PRIZE_MONEY"),
						   rset.getString("RECIPIENT_NO"),
						   rset.getString("GENDER"),
						   rset.getString("PHONE")));
			}
			
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				
				// JDBC 용 객체 자원 반납 (생성 역순)
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
				
			}
		
		return list;
		} // selectAll 메소드 영역 끝
	
	// 3. 상장명 키워드 검색
	public ArrayList<Prize> selectByPrize(Connection conn, String keyword) {
		
		ArrayList<Prize> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectByPrize");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ("%" + keyword + "%"));
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				list.add(new Prize(rset.getInt("PRIZE_NO"),
						   rset.getString("RECIPIENT_NAME"),
						   rset.getString("PRIZE_NAME"),
						   rset.getInt("PRIZE_MONEY"),
						   rset.getString("RECIPIENT_NO"),
						   rset.getString("GENDER"),
						   rset.getString("PHONE")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	} // selectByPrize 메소드 영역 끝
	
	// 4. 수상자명 키워드 검색
	public ArrayList<Prize> selectByRecipient(Connection conn, String keyword) {
			
		ArrayList<Prize> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectByRecipient");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ("%" + keyword + "%"));
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				list.add(new Prize(rset.getInt("PRIZE_NO"),
						   rset.getString("RECIPIENT_NAME"),
						   rset.getString("PRIZE_NAME"),
						   rset.getInt("PRIZE_MONEY"),
						   rset.getString("RECIPIENT_NO"),
						   rset.getString("GENDER"),
						   rset.getString("PHONE")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	} // selectByRecipient 메소드 영역 끝
	
	// 5. 2개 이상 상을 받은 사람 조회
	public ArrayList<Prize> selectHighPrize(Connection conn) {
		// 0) 필요한 변수들 셋팅
		ArrayList<Prize> list = new ArrayList<>();
		PreparedStatement pstmt = null; // SQL 문 실행 후 결과를 받을 변수
		ResultSet rset = null; // SELECT 문이 실행된 결과를 받을 변수
		
		// 실행할 SQL 문 (세미콜론 X)
		String sql = prop.getProperty("selectHighPrize");
		
		// PreparedStatement 객체 생성
		try {
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// SQL 문 실행 후 결과 받기
			rset = pstmt.executeQuery();
			
			// ResultSet 에서 한 행씩 뽑아서 VO로 옮기기
			while(rset.next()) {
			
				list.add(new Prize(rset.getInt("PRIZE_NO"),
								   rset.getString("RECIPIENT_NAME"),
								   rset.getString("PRIZE_NAME"),
								   rset.getInt("PRIZE_MONEY"),
								   rset.getString("RECIPIENT_NO"),
								   rset.getString("GENDER"),
								   rset.getString("PHONE")));
			}
			
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				
				// JDBC 용 객체 자원 반납 (생성 역순)
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
				
			}
		
		return list;
		} // selectHighPrize 메소드 영역 끝
	
	// 6. 가장 상금이 높은 상을 받은 사람 조회
	public ArrayList<Prize> selectHighMoney(Connection conn) {
		// 0) 필요한 변수들 셋팅
		ArrayList<Prize> list = new ArrayList<>();
		PreparedStatement pstmt = null; // SQL 문 실행 후 결과를 받을 변수
		ResultSet rset = null; // SELECT 문이 실행된 결과를 받을 변수
		
		// 실행할 SQL 문 (세미콜론 X)
		String sql = prop.getProperty("selectHighMoney");
		
		// PreparedStatement 객체 생성
		try {
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// SQL 문 실행 후 결과 받기
			rset = pstmt.executeQuery();
			
			// ResultSet 에서 한 행씩 뽑아서 VO로 옮기기
			while(rset.next()) {
			
				list.add(new Prize(rset.getInt("PRIZE_NO"),
								   rset.getString("RECIPIENT_NAME"),
								   rset.getString("PRIZE_NAME"),
								   rset.getInt("PRIZE_MONEY"),
								   rset.getString("RECIPIENT_NO"),
								   rset.getString("GENDER"),
								   rset.getString("PHONE")));
			}
			
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				
				// JDBC 용 객체 자원 반납 (생성 역순)
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
				
			}
		
		return list;
	} // selectHighMoney 메소드 영역 끝
	
	// 7. 수상 정보 변경
	public int updatePrize(Connection conn, Prize p) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updatePrize");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getPrizeName());
			pstmt.setInt(2, p.getPrizeMoney());
			pstmt.setInt(3, p.getPrizeNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	} // updatePrize 메소드 영역 끝
	
	// 8. 수상 정보 삭제
	public int deletePrize(Connection conn, int prizeNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deletePrize");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, prizeNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}
	
	
		
		
		
		
}
