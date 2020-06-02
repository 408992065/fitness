package com.stx.entity;

public class GuidanceMsg {
    private int videoid;
    private int coachid;
    private String uname;
    private String  jurl;
    private String description;
    private String  vtime;
    private int status;
    
    
	public GuidanceMsg(int videoid, int coachid, String uname, String jurl, String description, String vtime,
			int status) {
		this.videoid = videoid;
		this.coachid = coachid;
		this.uname = uname;
		this.jurl = jurl;
		this.description = description;
		this.vtime = vtime;
		this.status = status;
	}
	public int getVideoid() {
		return videoid;
	}
	public void setVideoid(int videoid) {
		this.videoid = videoid;
	}
	public int getCoachid() {
		return coachid;
	}
	public void setCoachid(int coachid) {
		this.coachid = coachid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getJurl() {
		return jurl;
	}
	public void setJurl(String jurl) {
		this.jurl = jurl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getVtime() {
		return vtime;
	}
	public void setVtime(String vtime) {
		this.vtime = vtime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
    
    
}
