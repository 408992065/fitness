package com.stx.entity;

public class Follow {
	private int followid;
	private int userid;
	private int coachid;
	private String ctime;
	
	
	public Follow(int userid, int coachid) {
		this.userid = userid;
		this.coachid = coachid;
	}
	public Follow(int followid, int userid, int coachid, String ctime) {
		this.followid = followid;
		this.userid = userid;
		this.coachid = coachid;
		this.ctime = ctime;
	}
	public int getFollowid() {
		return followid;
	}
	public void setFollowid(int followid) {
		this.followid = followid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
