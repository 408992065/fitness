package com.stx.entity;

public class FeedBack {
	private int feedbackid;
	private int userid;
	private String content;
	private String ctime;
	
	public FeedBack(int userid, String content) {
		this.userid = userid;
		this.content = content;
	}
	public FeedBack(int feedbackid, int userid, String content, String ctime) {
		this.feedbackid = feedbackid;
		this.userid = userid;
		this.content = content;
		this.ctime = ctime;
	}
	
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	public int getFeedbackid() {
		return feedbackid;
	}
	public void setFeedbackid(int feedbackid) {
		this.feedbackid = feedbackid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
