package com.kh.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.kh.controller.PrizeController;
import com.kh.model.vo.Prize;

public class PrizeView {
	
	private Scanner sc = new Scanner(System.in);
	private PrizeController pc = new PrizeController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("\n========== 수상자 관리 프로그램 ==========");
			System.out.println("1. 수상자 등록");
			System.out.println("2. 전체 수상자 조회");
			System.out.println("3. 상장명 키워드 검색");
			System.out.println("4. 수상자명 키워드 검색");
			System.out.println("5. 2개 이상 상을 받은 사람 조회");
			System.out.println("6. 가장 상금이 높은 상을 받은 사람 조회");
			System.out.println("7. 수상 정보 변경");
			System.out.println("8. 수상 정보 삭제");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴입력 : ");
			
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1 :
				insertRecipient();
				break;
			case 2 :
				selectAll();
				break;
			case 3 :
				selectByPrize();
				break;
			case 4 :
				selectByRecipient();
				break;
			case 5 :
				selectHighPrize();
				break;
			case 6 :
				selectHighMoney();
				break;
			case 7 :
				updatePrize();
				break;
			case 8 :
				deletePrize();
				break;
			case 0 :
				System.out.println("\n프로그램을 종료합니다. 안녕히 가세요 =)");
				return;
			default :
				System.out.println("\n잘못된 번호를 입력했습니다. 다시 입력해주세요.");
			}
		}
	} // mainMenu 메소드 영역 끝
	
	// 1. 수상자 등록
	public void insertRecipient() {
		System.out.println("\n----- 수상자 등록 ------");
		
		System.out.print("수상자 : ");
		String recipientName = sc.nextLine();
		
		System.out.print("상장명 : ");
		String PrizeName = sc.nextLine();
		
		System.out.print("상금 : ");
		int prizeMoney = sc.nextInt();
		sc.nextLine();
		
		System.out.print("주민등록번호 : ");
		String recipientNo = sc.nextLine();
		
		System.out.print("성별 (M/F) : ");
		String gender = sc.nextLine().toUpperCase();
		
		System.out.print("전화번호 (-없이 번호만 나열) : ");
		String phone = sc.nextLine();
		
		pc.insertRecipient(recipientName, PrizeName, prizeMoney, recipientNo, gender, phone);
	} // insertRecipient 메소드 영역 끝
	
	// 2. 전체 수상자 조회
	public void selectAll() {
		
		System.out.println("\n----- 전체 수상자 조회 -----");
		pc.selectAll();
		
	} // selectAll 메소드 영역 끝
	
	// 3. 상장명 키워드 검색
	public void selectByPrize() {
		System.out.println("\n----- 상장명 키워드 검색 -----");
		System.out.print("검색할 상장 키워드 : ");
		String keyword = sc.nextLine();
		
		pc.selectByPrize(keyword);
		
	} // selectByPrize 메소드 영역 끝
	
	// 4. 수상자명 키워드 검색
	public void selectByRecipient() {
		System.out.println("\n----- 수상자명 키워드 검색 -----");
		System.out.print("검색할 수상자명 키워드 : ");
		String keyword = sc.nextLine();
		
		pc.selectByRecipient(keyword);
		
	} // selectByRecipient 메소드 영역 끝
	
	// 5. 2개 이상 상을 받은 사람 조회
	public void selectHighPrize() {
		System.out.println("\n----- 2개 이상 상을 받은 사람 조회 -----");
		pc.selectHighPrize();
		
	} // selectHighPrize 메소드 영역 끝
	
	// 6. 가장 상금이 높은 상을 받은 사람 조회
	public void selectHighMoney() {
		System.out.println("\n----- 가장 상금이 높은 상을 받은 사람 조회 -----");
		pc.selectHighMoney();
		
	} // selectHighMoney 메소드 영역 끝
	
	// 7. 수상 정보 변경
	public void updatePrize() {
		System.out.println("\n----- 수상자 정보 변경 -----");
		System.out.print("변경할 수상번호 : ");
		int prizeNo = sc.nextInt();
		sc.nextLine();
		
		System.out.print("상장명 : ");
		String prizeName = sc.nextLine();
		
		System.out.print("상금 : ");
		int prizeMoney = sc.nextInt();
		sc.nextLine();
		
		pc.updatePrize(prizeNo, prizeName, prizeMoney);
	} // updatePrize 메소드 영역 끝
	
	// 8. 수상정보 삭제
	public void deletePrize() {
		System.out.println("\n----- 수상정보 삭제 -----");
		System.out.print("삭제할 수상번호 : ");
		int prizeNo = sc.nextInt();
		sc.nextLine();
		
		pc.deletePrize(prizeNo);
		
	} // deletePrize 메소드 영역 끝
	
	
//	==================================================================================================
// 서비스 요청 처리 후 사용자가 보게 될 응답화면들

	// 서비스 요청 성공 시 보여질 화면
	public void displaySuccess(String message)
	{
		System.out.println("\n서비스 요청 성공 : " + message);
	}
		
	// 서비스 요청 실패 시 보여질 화면
	public void displayFail(String message)
	{
		System.out.println("\n서비스 요청 실패 : " + message);
	}
		
	// 조회 서비스 요청 시 조회 결과가 없을 경우 보여질 화면
	public void displayNodata(String message)
	{
		System.out.println(message);
	}
		
	// 조회 서비스 요청 시 조회 결과가 여러 행일 경우 보여질 화면
	public void displayList(ArrayList<Prize> list)
	{
		for(Prize p : list)
			System.out.println(p);
		
		System.out.println("\n------------------");
		System.out.println("총 " + list.size() + "건의 데이터가 조회되었습니다.");
	}
		
	// 조회 서비스 요청 시 조화 결과가 한 행일 경우 보여질 화면
	public void displayOne(Prize p)
	{
		System.out.println("조회된 데이터는 다음과 같습니다.");
			System.out.println(p);
		}
}
