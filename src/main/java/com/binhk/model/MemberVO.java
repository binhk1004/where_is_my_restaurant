package com.binhk.model;

import java.sql.Date;

public class MemberVO {
	
	private int memberNum;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberPhone;
	private Date regDate;
	
	@Override
	public String toString() {
		return "MemberVO [memberNum=" + memberNum + ", memberId=" + memberId + ", memberPw=" + memberPw
				+ ", memberName=" + memberName + ", memberPhone=" + memberPhone + ", regDate=" + regDate + "]";
	}
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
}
	
	
