package com.kh.model.vo;

public class Prize {

// 수상번호, 수상자, 상장명, 상금, 주민등록번호, 성별, 전화번호
	
//	  PRIZE_NO NUMBER PRIMARY KEY, -- 수상번호
//    RECIPIENT VARCHAR2(30) NOT NULL, -- 수상자
//    PRIZE_NAME VARCHAR2(30) NOT NULL, -- 상장명
//    PRIZE_MONEY NUMBER NOT NULL, -- 상금
//    RECIPIENT_NO VARCHAR2(30) NOT NULL, -- 주민등록번호
//    GENDER CHAR(1) CHECK(GENDER IN ('M', 'F')),-- 성별
//    PHONE VARCHAR2(11) -- 전화번호
	
	private int prizeNo; // 수상번호
	private String recipientName; // 수상자 이름
	private String prizeName; // 상장명
	private int prizeMoney; // 상금
	private String recipientNo; // 주민등록번호
	private String gender; // 성별
	private String phone; // 전화번호
	
	public Prize() {}

	public Prize(int prizeNo, String recipientName, String prizeName, int prizeMoney, String recipientNo, String gender,
			String phone) {
		super();
		this.prizeNo = prizeNo;
		this.recipientName = recipientName;
		this.prizeName = prizeName;
		this.prizeMoney = prizeMoney;
		this.recipientNo = recipientNo;
		this.gender = gender;
		this.phone = phone;
	}

	public Prize(String recipientName) {
		this.recipientName = recipientName;
	}

	public int getPrizeNo() {
		return prizeNo;
	}

	public void setPrizeNo(int prizeNo) {
		this.prizeNo = prizeNo;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getPrizeName() {
		return prizeName;
	}

	public void setPrizeName(String prizeName) {
		this.prizeName = prizeName;
	}

	public int getPrizeMoney() {
		return prizeMoney;
	}

	public void setPrizeMoney(int prizeMoney) {
		this.prizeMoney = prizeMoney;
	}

	public String getRecipientNo() {
		return recipientNo;
	}

	public void setRecipientNo(String recipientNo) {
		this.recipientNo = recipientNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Prize [prizeNo=" + prizeNo + ", recipientName=" + recipientName + ", prizeName=" + prizeName
				+ ", prizeMoney=" + prizeMoney + ", recipientNo=" + recipientNo + ", gender=" + gender + ", phone="
				+ phone + "]";
	}
	
	
	
	
	
	
	
}
