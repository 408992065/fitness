package com.stx.entity;

public class UserNumber {
	
	private int rnumber;
	private int cnumber;
	private int vnumber;
	
	
	public UserNumber() {
	}
	
	public UserNumber(int rnumber, int cnumber, int vnumber) {
		this.rnumber = rnumber;
		this.cnumber = cnumber;
		this.vnumber = vnumber;
	}

	public int getVnumber() {
		return vnumber;
	}
	public void setVnumber(int vnumber) {
		this.vnumber = vnumber;
	}
	public int getRnumber() {
		return rnumber;
	}
	public void setRnumber(int rnumber) {
		this.rnumber = rnumber;
	}
	public int getCnumber() {
		return cnumber;
	}
	public void setCnumber(int cnumber) {
		this.cnumber = cnumber;
	}
	
	
}
