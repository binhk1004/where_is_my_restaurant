package com.binhk.model;

import java.io.Serializable;

public class RestautantVO implements Serializable {
	
	int num;
	int star;
	String name;
	String address;
	String review;
	int memberNum;
	String memberName;
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	
}


