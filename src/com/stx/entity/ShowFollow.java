package com.stx.entity;

public class ShowFollow {
	private int followid;
	private String url;
	private String cname;
	private int coachid;
	
	
	
	public ShowFollow(int followid, String url, String cname, int coachid) {
		this.followid = followid;
		this.url = url;
		this.cname = cname;
		this.coachid = coachid;
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
