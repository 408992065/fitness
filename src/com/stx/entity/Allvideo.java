package com.stx.entity;

public class Allvideo {
    private int videoid;
    private int coachid;
    private String jname;
    private String  jurl;
    private String description;
    private String  vtime;
    
    
    
	public Allvideo() {
	
	}
	public Allvideo(int videoid, int coachid, String jname, String jurl, String description, String vtime) {
		this.videoid = videoid;
		this.coachid = coachid;
		this.jname = jname;
		this.jurl = jurl;
		this.description = description;
		this.vtime = vtime;
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
	public String getJname() {
		return jname;
	}
	public void setJname(String jname) {
		this.jname = jname;
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
    
    
    

    
    

}
