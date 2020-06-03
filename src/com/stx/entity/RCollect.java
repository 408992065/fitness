package com.stx.entity;

public class RCollect {
	private int rcollectid;
	private int recipesid;
	private int userid;
	private String ctime;
	
	
	public RCollect(int recipesid, int userid) {
		this.recipesid = recipesid;
		this.userid = userid;
	}
	public RCollect(int rcollectid, int recipesid, int userid, String ctime) {
		this.rcollectid = rcollectid;
		this.recipesid = recipesid;
		this.userid = userid;
		this.ctime = ctime;
	}
	public int getRcollectid() {
		return rcollectid;
	}
	public void setRcollectid(int rcollectid) {
		this.rcollectid = rcollectid;
	}
	public int getRecipesid() {
		return recipesid;
	}
	public void setRecipesid(int recipesid) {
		this.recipesid = recipesid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	
	
}
