package com.stx.entity;

public class ShowFeed {
	private int feedbackid;
	private String name;
	private String content;
	private String ctime;
	
	
	
	public ShowFeed(int feedbackid, String name, String content, String ctime) {
		this.feedbackid = feedbackid;
		this.name = name;
		this.content = content;
		this.ctime = ctime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
