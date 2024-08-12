package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.service.PrizeService;
import com.kh.model.vo.Prize;
import com.kh.view.PrizeView;

public class PrizeController {

	// 1. 수상자 등록
	public void insertRecipient(String recipientName, String PrizeName, 
							    int prizeMoney, String recipientNo, String gender, String phone) {
		
		// 1) 요청 시 전달값들을 하나의 VO 객체로 가공
		Prize p = new Prize();
		p.setRecipientName(recipientName);
		p.setPrizeName(PrizeName);
		p.setPrizeMoney(prizeMoney);
		p.setRecipientNo(recipientNo);
		p.setGender(gender);
		p.setPhone(phone);
		
		// 2) Service 로 전달값을 넘기면서 요청 후 결과 받기
		int result = new PrizeService().insertRecipient(p);
		
		// 3) 결과에 따른 응답화면 지정
		if(result > 0) {
			
			new PrizeView().displaySuccess("수상자 등록 성공");
			
		} else {
			
			new PrizeView().displayFail("수상자 등록 실패");
			
		}
	} // insertRecipient 메소드 영역 끝
	
	// 2. 전체 수상자 조회
	public void selectAll() {
		// 1) 요청 시 전달값들을 하나의 VO 객체로 가공
		// -> 전달값이 없기 때문에 패스
		
		// 2) Service 로 전달값을 넘기면서 요청 후 결과 받기
		ArrayList<Prize> list = new PrizeService().selectAll();
	
		// 3) 결과에 따른 응답화면 지정
		if(list.isEmpty()) {
			
			new PrizeView().displayNodata("\n 전체 조회 결과가 없습니다.");
		} else {
			
			new PrizeView().displayList(list);
		}
		
	} // selectAll 메소드 영역 끝

	// 3. 상장명 키워드 검색
	public void selectByPrize(String keyword) {
		// 1) 요청 시 전달값들을 하나의 VO 객체로 가공
		//	-> 전달값이 하나기 때문에 패스
		
		// 2) Service 로 전달값을 넘기면서 요청 후 결과 받기
		//	-> 게임 키워드 로 검색 (여러행 조회)
		ArrayList<Prize> list = new PrizeService().selectByPrize(keyword);
		
		// 3) 결과에 따른 응답화면 지정
		if(list.size() == 0) {
			new PrizeView().displayNodata("\n" + keyword + "에 대한 검색 결과가 없습니다.");
		} else {
			
			new PrizeView().displayList(list);
		}
	} // selectByPrize
		
	// 4. 수상자명 키워드 검색
	public void selectByRecipient(String keyword) {
		// 1) 요청 시 전달값들을 하나의 VO 객체로 가공
		//	-> 전달값이 하나기 때문에 패스
		
		// 2) Service 로 전달값을 넘기면서 요청 후 결과 받기
		//	-> 게임 키워드 로 검색 (여러행 조회)
		ArrayList<Prize> list = new PrizeService().selectByRecipient(keyword);
		
		// 3) 결과에 따른 응답화면 지정
		if(list.size() == 0) {
			new PrizeView().displayNodata("\n" + keyword + "에 대한 검색 결과가 없습니다.");
		} else {
			
			new PrizeView().displayList(list);
		}
		
	} // selectByRecipient 메소드 영역 끝
	
	// 5. 2개 이상 상을 받은 사람 조회
	public void selectHighPrize() {
		// 1) 요청 시 전달값들을 하나의 VO 객체로 가공
		// -> 전달값이 없기 때문에 패스
		
		// 2) Service 로 전달값을 넘기면서 요청 후 결과 받기
		ArrayList<Prize> list = new PrizeService().selectHighPrize();
	
		// 3) 결과에 따른 응답화면 지정	
		if(list.size() == 0) {
			
			System.out.println("수상자 데이터가 없습니다.");
			
		} else {
			
			new PrizeView().displayList(list);
		}
				
	} // selectHighPrize 메소드 영역 끝
	
	// 6. 가장 상금이 높은 상을 받은 사람 조회
	public void selectHighMoney() {
		// 1) 요청 시 전달값들을 하나의 VO 객체로 가공
		// -> 전달값이 없기 때문에 패스
		
		// 2) Service 로 전달값을 넘기면서 요청 후 결과 받기
		ArrayList<Prize> list = new PrizeService().selectHighMoney();
	
		// 3) 결과에 따른 응답화면 지정	
		if(list.size() == 0) {
			
			System.out.println("수상자 데이터가 없습니다.");
			
		} else {
			
			new PrizeView().displayList(list);
		}
				
	} // selectHighMoney 메소드 영역 끝
	
	// 7. 수상 정보 변경
	public void updatePrize(int prizeNo, String prizeName, int prizeMoney) {
		Prize p = new Prize();
		p.setPrizeNo(prizeNo);
		p.setPrizeName(prizeName);
		p.setPrizeMoney(prizeMoney);
		
		int result = new PrizeService().updatePrize(p);
		
		if(result > 0) {
			new PrizeView().displaySuccess("수상 정보 변경 성공");
		} else {
			new PrizeView().displayFail("수상 정보 변경 실패");
		}
	} // updatePrize 메소드 영역 끝
	
	// 8. 수상 정보 삭제
	public void deletePrize(int prizeNo) {
		int result = new PrizeService().deletePrize(prizeNo);
		
		if(result > 0) {
			new PrizeView().displaySuccess("수상정보 삭제 성공");
			System.out.println("\n 수상번호" + prizeNo + "번이 삭제되었습니다.");
		} else {
			new PrizeView().displayFail("수상정보 삭제 실패");
		}
	} // deletePrize 메소드 영역 끝
	
	
}
