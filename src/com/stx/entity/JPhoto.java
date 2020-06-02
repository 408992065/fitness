package com.stx.entity;

public class JPhoto {
	private int jphotoid;
	private String url;
	private int coachid;
	private String ctime;
	
	
	
	public JPhoto() {

	}

	public JPhoto(String url, int coachid) {
		this.url = url;
		this.coachid = coachid;
	}

	public JPhoto(int jphotoid, String url, int coachid, String ctime) {
		this.jphotoid = jphotoid;
		this.url = url;
		this.coachid = coachid;
		this.ctime = ctime;
	}

	public int getJphotoid() {
		return jphotoid;
	}

	public void setJphotoid(int jphotoid) {
		this.jphotoid = jphotoid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getCoachid() {
		return coachid;
	}

	public void setCoachid(int coachid) {
		this.coachid = coachid;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	
	
	
}
