package com.stx.entity;

public class ShowFollow {
	private int followid;
	private String url;
	private String cname;
	private int coachid;
	private double price;
	
	
	
	
	public ShowFollow(int followid, String url, String cname, int coachid, double price) {
		this.followid = followid;
		this.url = url;
		this.cname = cname;
		this.coachid = coachid;
		this.price = price;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCoachid() {
		return coachid;
	}
	public void setCoachid(int coachid) {
		this.coachid = coachid;
	}
	public int getFollowid() {
		return followid;
	}
	public void setFollowid(int followid) {
		this.followid = followid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}

	
}
