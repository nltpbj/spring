package com.example.domain;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserVO {
	private String uid;
	private String uname;
	private String upass;
	private String address1;
	private String address2;
	private String photo;
	private String phone;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
	private Date regDate;
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	@Override
	public String toString() {
		return "UserVO [uid=" + uid + ", uname=" + uname + ", upass=" + upass + ", address1=" + address1 + ", address2="
				+ address2 + ", photo=" + photo + ", regDate=" + regDate + ", phone=" + phone + "]";
	}
	
}
