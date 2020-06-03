package com.stx.entity;

public class ShowVideo {
	   private int videoid;
	   private String uname;
	   private String url;
	   private String description;
	   private String ctime;
	   
	public ShowVideo() {

	}

	public ShowVideo(int videoid, String uname, String url, String description, String ctime) {
		this.videoid = videoid;
		this.uname = uname;
		this.url = url;
		this.description = description;
		this.ctime = ctime;
	}

	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getVideoid() {
		return videoid;
	}
	public void setVideoid(int videoid) {
		this.videoid = videoid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	   
	   
}
