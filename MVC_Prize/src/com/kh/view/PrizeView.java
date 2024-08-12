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
			System.out.println("\n========== ������ ���� ���α׷� ==========");
			System.out.println("1. ������ ���");
			System.out.println("2. ��ü ������ ��ȸ");
			System.out.println("3. ����� Ű���� �˻�");
			System.out.println("4. �����ڸ� Ű���� �˻�");
			System.out.println("5. 2�� �̻� ���� ���� ��� ��ȸ");
			System.out.println("6. ���� ����� ���� ���� ���� ��� ��ȸ");
			System.out.println("7. ���� ���� ����");
			System.out.println("8. ���� ���� ����");
			System.out.println("0. ���α׷� ����");
			
			System.out.print("�޴��Է� : ");
			
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
				System.out.println("\n���α׷��� �����մϴ�. �ȳ��� ������ =)");
				return;
			default :
				System.out.println("\n�߸��� ��ȣ�� �Է��߽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}
	} // mainMenu �޼ҵ� ���� ��
	
	// 1. ������ ���
	public void insertRecipient() {
		System.out.println("\n----- ������ ��� ------");
		
		System.out.print("������ : ");
		String recipientName = sc.nextLine();
		
		System.out.print("����� : ");
		String PrizeName = sc.nextLine();
		
		System.out.print("��� : ");
		int prizeMoney = sc.nextInt();
		sc.nextLine();
		
		System.out.print("�ֹε�Ϲ�ȣ : ");
		String recipientNo = sc.nextLine();
		
		System.out.print("���� (M/F) : ");
		String gender = sc.nextLine().toUpperCase();
		
		System.out.print("��ȭ��ȣ (-���� ��ȣ�� ����) : ");
		String phone = sc.nextLine();
		
		pc.insertRecipient(recipientName, PrizeName, prizeMoney, recipientNo, gender, phone);
	} // insertRecipient �޼ҵ� ���� ��
	
	// 2. ��ü ������ ��ȸ
	public void selectAll() {
		
		System.out.println("\n----- ��ü ������ ��ȸ -----");
		pc.selectAll();
		
	} // selectAll �޼ҵ� ���� ��
	
	// 3. ����� Ű���� �˻�
	public void selectByPrize() {
		System.out.println("\n----- ����� Ű���� �˻� -----");
		System.out.print("�˻��� ���� Ű���� : ");
		String keyword = sc.nextLine();
		
		pc.selectByPrize(keyword);
		
	} // selectByPrize �޼ҵ� ���� ��
	
	// 4. �����ڸ� Ű���� �˻�
	public void selectByRecipient() {
		System.out.println("\n----- �����ڸ� Ű���� �˻� -----");
		System.out.print("�˻��� �����ڸ� Ű���� : ");
		String keyword = sc.nextLine();
		
		pc.selectByRecipient(keyword);
		
	} // selectByRecipient �޼ҵ� ���� ��
	
	// 5. 2�� �̻� ���� ���� ��� ��ȸ
	public void selectHighPrize() {
		System.out.println("\n----- 2�� �̻� ���� ���� ��� ��ȸ -----");
		pc.selectHighPrize();
		
	} // selectHighPrize �޼ҵ� ���� ��
	
	// 6. ���� ����� ���� ���� ���� ��� ��ȸ
	public void selectHighMoney() {
		System.out.println("\n----- ���� ����� ���� ���� ���� ��� ��ȸ -----");
		pc.selectHighMoney();
		
	} // selectHighMoney �޼ҵ� ���� ��
	
	// 7. ���� ���� ����
	public void updatePrize() {
		System.out.println("\n----- ������ ���� ���� -----");
		System.out.print("������ �����ȣ : ");
		int prizeNo = sc.nextInt();
		sc.nextLine();
		
		System.out.print("����� : ");
		String prizeName = sc.nextLine();
		
		System.out.print("��� : ");
		int prizeMoney = sc.nextInt();
		sc.nextLine();
		
		pc.updatePrize(prizeNo, prizeName, prizeMoney);
	} // updatePrize �޼ҵ� ���� ��
	
	// 8. �������� ����
	public void deletePrize() {
		System.out.println("\n----- �������� ���� -----");
		System.out.print("������ �����ȣ : ");
		int prizeNo = sc.nextInt();
		sc.nextLine();
		
		pc.deletePrize(prizeNo);
		
	} // deletePrize �޼ҵ� ���� ��
	
	
//	==================================================================================================
// ���� ��û ó�� �� ����ڰ� ���� �� ����ȭ���

	// ���� ��û ���� �� ������ ȭ��
	public void displaySuccess(String message)
	{
		System.out.println("\n���� ��û ���� : " + message);
	}
		
	// ���� ��û ���� �� ������ ȭ��
	public void displayFail(String message)
	{
		System.out.println("\n���� ��û ���� : " + message);
	}
		
	// ��ȸ ���� ��û �� ��ȸ ����� ���� ��� ������ ȭ��
	public void displayNodata(String message)
	{
		System.out.println(message);
	}
		
	// ��ȸ ���� ��û �� ��ȸ ����� ���� ���� ��� ������ ȭ��
	public void displayList(ArrayList<Prize> list)
	{
		for(Prize p : list)
			System.out.println(p);
		
		System.out.println("\n------------------");
		System.out.println("�� " + list.size() + "���� �����Ͱ� ��ȸ�Ǿ����ϴ�.");
	}
		
	// ��ȸ ���� ��û �� ��ȭ ����� �� ���� ��� ������ ȭ��
	public void displayOne(Prize p)
	{
		System.out.println("��ȸ�� �����ʹ� ������ �����ϴ�.");
			System.out.println(p);
		}
}
