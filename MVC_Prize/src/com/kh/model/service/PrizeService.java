package com.kh.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.model.dao.PrizeDao;
import com.kh.model.vo.Prize;

public class PrizeService {

	// 1. 수상자 등록
	public int insertRecipient(Prize p) {
		
		// 1) Connection 객체 생성
		Connection conn = JDBCTemplate.getConnection();
				
		// 2) DAO 로 Connection 객체와 전달값을 넘기면서 요청 후 결과 받기
		int result = new PrizeDao().insertRecipient(conn, p);
		
		// 3) 트랜잭션 처리
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		return result;
	} // insertRecipient 메소드 영역 끝
	
	// 2. 전체 수상자 조회
	public ArrayList<Prize> selectAll() {
		
		// 1) Connection 객체 생성
		Connection conn = JDBCTemplate.getConnection();
		
		// 2) DAO 로 Connection 객체와 전달값을 넘기면서 요청 후 결과 받기
		ArrayList<Prize> list = new PrizeDao().selectAll(conn);
		
		// 3) 트랜잭션 처리
		// > SELECT 문을 실행했으므로 패스
		
		// 4) Connection 객체 반납
		JDBCTemplate.close(conn);
		
		// 5) Controller 로 결과 반환
		return list;
		
	} // selectAll 메소드 영역 끝
	
	// 3. 상장명 키워드 검색
	public ArrayList<Prize> selectByPrize(String keyword) {
		
		// 1) Connection 객체 생성
		Connection conn = JDBCTemplate.getConnection();
		
		// 2) DAO 로 Connection 객체와 전달값을 넘기면서 요청 후 결과 받기
		ArrayList<Prize> list = new PrizeDao().selectByPrize(conn, keyword);
		
		// 3) 트랜잭션 처리
		//	-> SELECT 문을 실행했으므로 패스
		
		// 4) Connection 객체 반납
		JDBCTemplate.close(conn);
		
		// 5) Controller 로 결과 반환
		return list;
	} // selectByPrize 메소드 영역 끝
	
	// 4. 수상자명 키워드 검색
	public ArrayList<Prize> selectByRecipient(String keyword) {
		
		// 1) Connection 객체 생성
		Connection conn = JDBCTemplate.getConnection();
		
		// 2) DAO 로 Connection 객체와 전달값을 넘기면서 요청 후 결과 받기
		ArrayList<Prize> list = new PrizeDao().selectByRecipient(conn, keyword);
		
		// 3) 트랜잭션 처리
		//	-> SELECT 문을 실행했으므로 패스
		
		// 4) Connection 객체 반납
		JDBCTemplate.close(conn);
		
		// 5) Controller 로 결과 반환
		return list;
	} // selectByRecipient 메소드 영역 끝
	
	// 5. 2개 이상 상을 받은 사람 조회
	public ArrayList<Prize> selectHighPrize() {
		
		// 1) Connection 객체 생성
		Connection conn = JDBCTemplate.getConnection();
		
		// 2) DAO 로 Connection 객체와 전달값을 넘기면서 요청 후 결과 받기
		ArrayList<Prize> list = new PrizeDao().selectHighPrize(conn);
		
		// 3) 트랜잭션 처리
		// > SELECT 문을 실행했으므로 패스
		
		// 4) Connection 객체 반납
		JDBCTemplate.close(conn);
		
		// 5) Controller 로 결과 반환
		return list;
		
	} // selectHighPrize 메소드 영역 끝
	
	// 6. 가장 상금이 높은 상을 받은 사람 조회
	public ArrayList<Prize> selectHighMoney() {
		
		// 1) Connection 객체 생성
		Connection conn = JDBCTemplate.getConnection();
		
		// 2) DAO 로 Connection 객체와 전달값을 넘기면서 요청 후 결과 받기
		ArrayList<Prize> list = new PrizeDao().selectHighMoney(conn);
		
		// 3) 트랜잭션 처리
		// > SELECT 문을 실행했으므로 패스
		
		// 4) Connection 객체 반납
		JDBCTemplate.close(conn);
		
		// 5) Controller 로 결과 반환
		return list;
		
	} // selectHighMoney 메소드 영역 끝
	
	// 7. 수상 정보 변경
	public int updatePrize(Prize p) {
		
		// 1) Connection 객체 생성
		Connection conn = JDBCTemplate.getConnection();
		
		// 2) DAO 로 Connection 객체와 전달값을 넘기면서 요청 후 결과 받기
		int result = new PrizeDao().updatePrize(conn, p);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		return result;
		
	} // updatePrize 메소드 영역 끝
	
	// 8. 수상자 정보 삭제
	public int deletePrize(int prizeNo) {
		
		// 1) Connection 객체 생성
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new PrizeDao().deletePrize(conn, prizeNo);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		return result;
	}
	
	
}
